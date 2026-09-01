import React, { useState, useEffect } from 'react';
import SearchScreen from './financeSearch';
import ResultScreen from './financeData';
import {Card,Grid,Typography } from "@mui/material"
import {apiToGetEmployeeCanteenData,apiToDownloadExcel} from "../../middleware/apiCalls/financesApiCall"
import NotificationComponent from "../commons/notification/notificationComponent"
import { constructErrorMessage } from "../../helpers/function"


const FinancesScreen=()=> {
    const [employeeData, setEmployeeData] = useState([]);
    const [error, setError] = useState('');
    const [showResult, setShowResult] = useState(false);
    const [ date , setDate]= useState('');
    const [state, setState] = useState({
        notificationType: "",
        notificationMessage: "",
      })

    // useEffect(() => {
    //     fetchData(); // Load data when the component mounts
    // }, []);

    //notification message
  const getNotificationMessage = async (type, msg) => {
    debugger
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


    // const fetchData = async () => {
    //     try {
    //         const response = await fetch('http://localhost:9090/integra/api/employee/finance');
    //         if (!response.ok) {
    //             throw new Error('Failed to fetch employee data');
    //         }
    //         const data = await response.json();
    //         setEmployeeData(data.respBuffer);
    //         setShowResult(false); // Reset showResult to false to show initial data
    //         setError('');
    //     } catch (error) {
    //         console.error('Error fetching employee data:', error);
    //         setError('Failed to fetch employee data. Please try again.');
    //     }
    // };

    const handleSearch = async (selectedDate) => {
      let result = await apiToGetEmployeeCanteenData(selectedDate)
      if (result && result.status === 200) {
          if (result.data.respCode === 200 || result.data.respCode === 200) {
              setShowResult(true); // Show the search results
              setEmployeeData(result.data.respBuffer)
              setDate(selectedDate);
              setError('');
          } else {
              getNotificationMessage("error", result.data)
          }
      }}

      const handleDownloadExcel = async () => {
        try {
            const response = await fetch(`http://localhost:9090/integra/api/employee/excel?date=${date}`, {
                method: 'GET',
                headers: {
                    'Content-Type': 'application/json'
                }
            });
    
            if (!response.ok) {
                throw new Error('Failed to download Excel file');
            }
    
            const blob = await response.blob();
    
            // Extracting month from selected date
            const selectedDate = new Date(date);
            const month = selectedDate.toLocaleString('default', { month: 'long' });
    
            const url = window.URL.createObjectURL(new Blob([blob]));
            const link = document.createElement('a');
    
            // Constructing filename with month
            const filename = `employee_data_${month}.xlsx`;
    
            link.href = url;
            link.setAttribute('download', filename);
            document.body.appendChild(link);
            link.click();
            document.body.removeChild(link);
        } catch (error) {
            console.error('Error exporting data to Excel:', error);
            // Handle error, show notification, etc.
        }
    };


    return (
        <>
         <NotificationComponent
        notificationType={state.notificationType}
        notificationMessage={state.notificationMessage}
      />
        <Grid container>
        <Grid item xs={1}>
            
            </Grid>
            <Grid item xs={10}>
            <Card style={{padding:"1%"}}>
            <Typography gutterBottom variant="h5" component="div" fontFamily="Raleway">
            <center>
              <h3>EMPLOYEE CANTEEN REGISTERATION - MONTHLY CONSUMPTION</h3>               
              </center>
            </Typography>            
            <SearchScreen
           onSearch={handleSearch} onReset={handleReset}
            handleDownloadExcel={handleDownloadExcel}
            />
            <br></br>
            <ResultScreen
            employeeData={employeeData}
            />
            <br></br>
            <br></br>
            <br></br>
            </Card>
            </Grid>
            <Grid item xs={1}>
            
            </Grid>
        </Grid>
        </>
    );
}

export default FinancesScreen;