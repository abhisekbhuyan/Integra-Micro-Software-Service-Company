import React, { useState, useEffect } from 'react';
import HrSearch from './hrSearch';
import HrData from './hrData';
import { Card, Grid, Typography } from "@mui/material"
import NotificationComponent from "../commons/notification/notificationComponent"
import { constructErrorMessage } from "../../helpers/function"
import { apiToGetAllEmployeeDetails, apiToGetEmployeeDetailsById, apiToUpdateEmployeeDetails } from "../../middleware/apiCalls/hrApiCall"
import HrForm from "./hrForm"

const Hr = () => {
    const [employeeData, setEmployeeData] = useState([]);
    const [error, setError] = useState('');
    const [showResult, setShowResult] = useState(false);
    const [date, setDate] = useState('');
    const [state, setState] = useState({
        notificationType: "",
        notificationMessage: "",
        isForm: false,
        formData: [],
        employeeId:"",
        first_name:"",
        last_name:"",
        emp_id:"",

    })

    // useEffect(() => {
    //     fetchData(); // Load data when the component mounts
    // }, []);

    //notification message
    const getNotificationMessage = async (type, msg) => {
        let message = "";
        if (type === "error") {
            message = await constructErrorMessage(msg);
        } else {
            message = msg;
        }
        setState((prevState) => ({
            ...prevState,
            notificationType: type,
            notificationMessage: message,
        }));
    };

    const handleReset = () => {
        setDate(null);
        setEmployeeData([])
        // fetchData(); // Reset to initial data
    };

    const handleSearch = async (selectedDate) => {
        // debugger
        // console.log("cnhash");
        let result = await apiToGetAllEmployeeDetails(selectedDate)
        if (result && result.status === 200) {
            if (result.data.respCode === 200) {
                setShowResult(true); // Show the search results
                setEmployeeData(result.data.respBuffer)
                setDate(selectedDate);
                setError('');
            } else {
                getNotificationMessage("error", result.data)
            }
        }
    };

    const closeForm = () => {
        setState((prevState) => ({
            ...prevState,
            isForm: false,
        }));
    }

    //edit
    const editForm = async (_e, emp, first_name, last_name, emp_id) => {
        let result = await apiToGetEmployeeDetailsById(date, emp)
        if (result && result.status === 200) {
            if (result.data.respCode === 200) {
                setState((prevState) => ({
                    ...prevState,
                    isForm: true,
                    formData: result.data.respBuffer || [],
                    employeeId:emp,
                    first_name:first_name,
                    last_name:last_name,
                    emp_id:emp_id,
                }));
            }
            else {
                getNotificationMessage("error", result.data)
            }
        } else {
            getNotificationMessage("error", result.data)
        }

    }

    const updateStatus=async(payload)=>{
        let result = await apiToUpdateEmployeeDetails(state.employeeId,payload)
        if(result && result.status === 200){
            if(result.data.respCode === 200||
                result.data.respCode === 201){
                getNotificationMessage("success", "Status Updated..")
                handleSearch(date)
            }else{
                getNotificationMessage("error", result.data)
            }
        }else{
            getNotificationMessage("error", result.data)
        }
    }

    const renderView = () => {
        if (state.isForm === true) {
            return (
                <>
                    <HrForm
                        formData={state.formData}
                        closeForm={closeForm}
                        date={date}
                        updateStatus={updateStatus}
                        first_name={state.first_name}
                        last_name={state.last_name}
                        emp_id={state.emp_id}
                    />
                </>
            )
        } else {
            return (
                <>
                    <Grid container>
                        <Grid item xs={1}>

                        </Grid>
                        <Grid item xs={10}>
                            <Card style={{ padding: "1%" }}>
                            <Typography gutterBottom variant="h5" component="div" fontFamily="Raleway">
                                <center>
                                <h3>EMPLOYEE CANTEEN LOGGING REVIEW - HR</h3> 
                                </center>
                                </Typography>
                                <HrSearch
                                    onSearch={handleSearch} onReset={handleReset}
                                    date={date} 
                                        setDate={setDate}
                                />
                                <br></br>
                                <HrData
                                    employeeData={employeeData} showResult={showResult} date={date}
                                    editForm={editForm}
                                />
                                <br></br>
                                <br></br>
                                
                            </Card>
                            
                        </Grid>
                        <Grid item xs={1}>
                        </Grid>
                        <br></br>
                        <br></br>
                    </Grid>
                </>
            )
        }
    }


    return (
        <>
            <NotificationComponent
                notificationType={state.notificationType}
                notificationMessage={state.notificationMessage}
            />
            {renderView()}
        </>
    );
}

export default Hr;