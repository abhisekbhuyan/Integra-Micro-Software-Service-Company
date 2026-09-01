import React, { useState } from 'react';
import axios from 'axios';
import ArrowDownwardIcon from '@mui/icons-material/ArrowDownward';
import { Grid, TextField, Button, Container, Typography, Box, Card, useMediaQuery } from '@mui/material';
import { useTheme } from '@mui/material/styles';
import NotificationComponent from "../commons/notification/notificationComponent";
import { constructErrorMessage } from "../../helpers/function"
import { apiToSubmitCateenData } from "../../middleware/apiCalls/authApiCall"
import moment from 'moment';


const Support = () => {
  const theme = useTheme();
  const UiResponsive = useMediaQuery(theme.breakpoints.up('sm'));
  const [notification, setNotification] = useState({
    notificationType: "",
    notificationMessage: "",
  });

  const [formData, setFormData] = useState({
    emp_id: '',
    created_date: null,
   
});


const handleChange = (e) => {
  const { name, value } = e.target;
  if (name === 'created_date') {
    const selectedDate = new Date(value);
    const currentDate = new Date();
  
    if (selectedDate > currentDate) {
      alert("Future dates are not allowed");
      return; 
    }
  }
  setFormData({ ...formData, [name]: value });
};

  const handleSubmit = async (e) => {

    e.preventDefault();
    let date=moment(formData.created_date).format("DD-MM-YYYY")
    let payload={
      emp_id:formData.emp_id,
      created_date:date
    }

if(!payload.emp_id){
  setNotification({
    notificationType: "warning",
    notificationMessage: "Please enter Employee ID",
});

return;
}
if(!payload.created_date){
  setNotification({
    notificationType: "warning",
    notificationMessage: "Please select date",
});
return;
}


    const response = await apiToSubmitCateenData(payload);
    if (response && response.status === 200) {
      if (response.data.respCode === 200 || response.data.respCode === 201) {
        setNotification({
          notificationType: "success",
          notificationMessage: "Data added successfully",
      });
      } else {
        setNotification({
          notificationType: "error",
          notificationMessage: "Employee with the same ID and Created Date already exists/Employee Does not Exist",
      });

      }
    } else {
      setNotification({
        notificationType: "error",
        notificationMessage: "Failed to add data",
    });
    }
  };

  return (
    <>
      <NotificationComponent
        notificationType={notification.notificationType}
        notificationMessage={notification.notificationMessage}
      />
      <Grid container>
        <Grid item xs={1}></Grid>
        <Grid item xs={10}>
          <Card style={{padding:"1%"}}>
          <Typography gutterBottom variant="h5" component="div" fontFamily="Raleway">
            <center>
              <h4> SUPPORT USER</h4>
              <h3>EMPLOYEE CANTEEN LOGGING - SUPPORT</h3> 
               FILL IN THE DETAILS BELOW <ArrowDownwardIcon></ArrowDownwardIcon>
              </center>
            </Typography>
            <br></br>
            
            <form onSubmit={handleSubmit}>
              <Grid container spacing={2} justifyContent="center">
                <Grid item xs={8}>
                  <TextField
                    fullWidth
                    style={{ marginBottom: '20px', fontSize: '20px' }} // Adjusted fontSize here
                    label="Employee ID"
                    id="emp_id"
                    name="emp_id"
                    value={formData.emp_id}
                    onChange={handleChange}
                    size="large"
                    variant="outlined"
                  />
                </Grid>
                <Grid item xs={8}>
                  <TextField
                    fullWidth
                    style={{ marginBottom: '20px', fontSize: '20px' }} // Adjusted fontSize here
                    type="date"
                    // label="Created Date"
                    id="created_date"
                    name="created_date"
                    value={formData.created_date}
                    onChange={handleChange}
                    size="large"
                    variant="outlined"
                    InputLabelProps={{
                      shrink: true,
                    }}
                    inputProps={{
                      max: new Date().toISOString().split('T')[0], 
                    }}
                  />
                </Grid>
              </Grid>
              <Grid container spacing={2} justifyContent="center">
                <Grid item xs={5}>

                </Grid>
                <Grid item xs={2}>
                  <Button
                    fullWidth
                    type="submit"
                    variant="contained"
                    color="success"
                    style={{ marginTop: '20px',marginBottom: '20px' }}
                  >
                    Submit
                  </Button>
                </Grid>
                <Grid item xs={5}>

                </Grid>
              </Grid>
            </form>
          </Card>
        </Grid>
        <Grid item xs={1}></Grid>
      </Grid>

    </>
  );
};

export default Support;