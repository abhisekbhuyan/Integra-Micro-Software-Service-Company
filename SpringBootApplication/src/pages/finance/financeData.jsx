    // ResultScreen.js
    import React from 'react';
    import { Button, Table, TableHead, TableBody, TableRow, TableCell, Alert } from '@mui/material';


    const ResultScreen = ({ employeeData, showResult, date }) => {

        const tableBodyView = () => {
            if (employeeData.length === 0) {
                return (
                    <>
                        <TableRow>
                            <TableCell colSpan={6}>
                                <div style={{ width: "100%", position: "relative" }}>
                                    <Alert severity="warning">

                                        No data found for the selected month.
                                    </Alert>
                                </div>
                            </TableCell>
                        </TableRow>
                    </>
                )
            } else {
                return (
                    <>
                        {employeeData.map((employee) => (
                            <TableRow key={employee.id}>
                                <TableCell>{employee.emp_id}</TableCell>
                                <TableCell>{employee.first_name}</TableCell>
                                <TableCell>{employee.last_name}</TableCell>
                                <TableCell>{employee.email}</TableCell>
                                <TableCell>{employee.maxCount}</TableCell>
                                <TableCell>{employee.total}</TableCell>
                            </TableRow>
                        ))}
                    </>
                )
            }
        }


        return (
            <>
                <Table>
                    <TableHead>
                        <TableRow>
                            <TableCell>Employee ID</TableCell>
                            <TableCell>First Name</TableCell>
                            <TableCell>Last Name</TableCell>
                            <TableCell>Email</TableCell>
                            <TableCell>Meal Count</TableCell>
                            <TableCell>Total Amount</TableCell>
                        </TableRow>
                    </TableHead>
                    <TableBody>
                        {tableBodyView()}
                    </TableBody>
                </Table>
            </>
        );
    }

    export default ResultScreen;
