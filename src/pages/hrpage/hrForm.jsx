import React from "react";
import { Table, TableHead, TableBody, TableRow, TableCell, Grid, Alert, Card, Typography, Tooltip, IconButton, Button } from '@mui/material';
import ArrowBackIcon from '@mui/icons-material/ArrowBack';
import ButtonComponent from "../commons/buttonComponent/buttonComponent";

const HrForm = ({ formData, closeForm, date, updateStatus, first_name, last_name, emp_id }) => {

    const handleApprove = (_e) => {
        let payload = {
            "status_code": 1,
            "date": date
        }
        updateStatus(payload)
    }

    const handleReject = (_e) => {
        let payload = {
            "status_code": 0,
            "date": date
        }
        updateStatus(payload)
    }

    const tableBodyView = () => {
        if (formData.length === 0) {
            return (
                <>
                    <TableRow>
                        <TableCell colSpan={6}>
                            <div style={{ width: "100%", position: "relative" }}>
                                <Alert severity="warning">

                                    No record found for the selected date.
                                </Alert>
                            </div>
                        </TableCell>
                    </TableRow>

                </>
            )
        } {
            return (
                <>

                    {formData.map((employee) => (
                        <TableRow key={employee.id}>
                            <TableCell>{employee.created_date}</TableCell>
                            <TableCell>{employee.meal_amount}</TableCell>


                        </TableRow>
                    ))}
                </>
            )
        }
    }

// const getemp_name=()=>{
//     return(
//     formData.map((employee)=>(
//     )

// )};



    return (
        <>
            <Grid container>
                <Grid item xs={1}>

                </Grid>
                <Grid item xs={10}>
                    <Card style={{ padding: "1%" }}>
                        <Grid container>
                            <Grid item xs={1}>
                                <Tooltip title="View Employee Details">
                                    <IconButton onClick={(e) => closeForm(e)}><ArrowBackIcon /></IconButton>
                                </Tooltip>
                            </Grid>
                            <Grid item >
                                <Typography gutterBottom variant="h5" component="div" fontFamily="Raleway">
                                   RECORD AUDIT - FOR
                                   <Grid item>EMPLOYEE ID : {emp_id}</Grid> 
                                   <Grid item>EMPLOYEE NAME : {first_name + " " + last_name}</Grid> 
                                    </Typography>
                                    <br></br>
                                    </Grid></Grid>

                            <Grid container>
                            <Grid item  alignContent={"center"}>
                            {/* <Grid item xs={1}> */}
                                <ButtonComponent  color="success" handleChange={(e) => handleApprove(e)}  label={"APPROVE"}></ButtonComponent>&ensp;&ensp;
                            {/* </Grid>
                            <Grid item xs={1}> */}
                                <ButtonComponent style={{ marginRight: "20px" }}  handleChange={(e) => handleReject(e)} color="error"  label={"REJECT"}></ButtonComponent>
                            {/* </Grid> */}
                        </Grid></Grid>
                        

                        <br></br>
                        <Grid container>
                            <Grid item xs={12}>
                                <Table>
                                    <TableHead>
                                        <TableRow>
                                            <TableCell>Date</TableCell>
                                            <TableCell>Amount</TableCell>
                                        </TableRow>
                                    </TableHead>
                                    <TableBody>
                                        {tableBodyView()}
                                    </TableBody>
                                </Table>


                            </Grid>
                        </Grid>
                    </Card>
                </Grid>
                <Grid item xs={1}>

                </Grid>
            </Grid>

        </>
    )
}
export default HrForm;