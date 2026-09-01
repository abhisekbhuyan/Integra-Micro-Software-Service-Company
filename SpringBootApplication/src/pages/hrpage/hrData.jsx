import React from 'react';
import {Table, TableHead, TableBody, TableRow, TableCell, Grid,Alert,Tooltip,IconButton } from '@mui/material';
import VisibilityIcon from '@mui/icons-material/Visibility';


function HrData({ employeeData,editForm}) {

    const tableBodyView = () => {
        if (employeeData.length === 0) {
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

                    {employeeData.map((employee) => (
                        <TableRow key={employee.id}>
                            <TableCell>{employee.emp_id}</TableCell>
                            <TableCell>{employee.first_name}</TableCell>
                            <TableCell>{employee.last_name}</TableCell>
                            <TableCell>{employee.maxCount}</TableCell>
                            <TableCell>{employee.total}</TableCell>
                            <TableCell>
                            <Tooltip title="View Employee Details">
                                <IconButton onClick={(e)=>editForm(e,employee.emp_id,employee.first_name,employee.last_name,employee.emp_id)}><VisibilityIcon/></IconButton>
                            </Tooltip>
                            
                            </TableCell>
                            
                        </TableRow>
                    ))}
                </>
            )
        }
    }



    return (
        <>
            <Grid container>
                <Grid item xs={12}>
                    <Table>
                        <TableHead>
                            <TableRow>
                                <TableCell>Employee ID</TableCell>
                                <TableCell>First Name</TableCell>
                                <TableCell>Last Name</TableCell>
                                <TableCell>Meal Count</TableCell>
                                <TableCell>Total Amount</TableCell>
                                <TableCell>Actions</TableCell>
                            </TableRow>
                        </TableHead>
                        <TableBody>
                            {tableBodyView()}
                        </TableBody>
                    </Table>


                </Grid>
            </Grid>
        </>
    );
}

export default HrData;
