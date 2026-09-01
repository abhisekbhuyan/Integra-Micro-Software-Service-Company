import React, { useState } from 'react';
import { TextField, Button, Typography, Grid } from '@mui/material';
import ButtonComponent from '../commons/buttonComponent/buttonComponent';
import NotificationComponent from '../commons/notification/notificationComponent';


const SearchScreen = ({ onSearch, onReset, handleDownloadExcel }) => {
    const [selectedDate, setSelectedDate] = useState('');
    const [notification, setNotification] = useState({
        notificationType: "",
        notificationMessage: "",
    });

    const handleDateChange = (event) => {
        setSelectedDate(event.target.value);
    };

    const handleSearch = (_e) => {
        if (!selectedDate) {
            setNotification({
                notificationType: "warning",
                notificationMessage: "Please select a date",
            });
            return;
        }
        
        onSearch(selectedDate);
    };

    const handleReset = (_e) => {
        setSelectedDate('');
        onReset();
    };

    return (
        <>
        <NotificationComponent
        notificationType={notification.notificationType}
        notificationMessage={notification.notificationMessage}
      />
            <Grid container>
                <Grid item xs={12}>
                <Typography gutterBottom variant="h5" component="div" fontFamily="monospace">
            
              SEARCH             
              
            </Typography> 
                </Grid>
            </Grid>
            <br></br>
            <Grid container>
                <Grid item xs={3}>
                    <TextField
                        id="date"
                        label="Date"
                        type="month"
                        value={selectedDate}
                        onChange={handleDateChange}
                        InputLabelProps={{
                            shrink: true,
                        }}
                    />
                </Grid>
            </Grid>
            <br></br>
            <Grid container>
                <Grid item xs={5}>
                    <ButtonComponent  handleChange={(e) => handleSearch(e)} color="success" label="SEARCH" style={{ height: "40px", margin: "0%", width: "70%" }}></ButtonComponent>                     
                    &ensp;&ensp;<ButtonComponent  handleChange={(e) =>handleReset(e)} color="error" label="RESET" style={{ height: "40px", margin: "0%", width: "100%" }}></ButtonComponent>
                </Grid>
                <Grid item xs={5}></Grid>
                <Grid item xs={2} style={{ float: "right" }}>
                    <ButtonComponent handleChange={(e) =>handleDownloadExcel(e)} label="Download Excel" style={{ height: "40px", margin: "0%", width: "100%" }}></ButtonComponent>
                </Grid>
            </Grid>
            <Grid container>
                <Grid item xs={3}>
                    
                </Grid>
            </Grid>
        </>
    );
}

export default SearchScreen;
