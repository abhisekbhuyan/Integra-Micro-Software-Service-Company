// import React, { useState } from "react";


// import { TextField, Button, Box, Grid, Paper, Alert} from "@mui/material";
// import { RoleCheck } from "../../helpers/function";
// import {apiToGetEmployeeDetail} from "../../middleware/apiCalls/authApiCall";
// import {Card, CardActions, CardContent, CardMedia, Typography} from '@mui/material';
// import NotificationComponent from "../commons/notification/notificationComponent";
// import { constructErrorMessage } from "../../helpers/function"



// const Login = () => {
//   const [user, setUser] = useState("");
//   const [state, setState] = useState({
//     notificationType: "",
//     notificationMessage: "",
//   })

//     //notification message
//     const getNotificationMessage = async (type, msg) => {
//       //debugger
//       let message = "";
//       if (type === "error") {
//         message = await constructErrorMessage(msg);
//       } else {
//         message = msg;
//       }
//       setState((prevState) => ({
//         ...prevState,
//         notificationType: type,
//         notificationMessage: message,
//       }));
//     };

//   const handleText = (e) => {
//     let u = e.target.value;
//     setUser(u);
//   };

//   const handleButton = async() => {
//     let result = await apiToGetEmployeeDetail(user)
//     if(result && result.status===200){
//       if(result && result.data.respCode===200){
//       let details = result.data.respBuffer||{}
//       localStorage.setItem("role",details.role_id)
//       localStorage.setItem("employId",user)
//       localStorage.setItem("firstName",details.first_name)
//       localStorage.setItem("lastName",details.last_name)
//       localStorage.setItem("emailId",details.email)
//       RoleCheck()
//       }
//       else{
//         getNotificationMessage("error", result.data)
//     }
//     }
//   };

//   return (
//     <>
//     <NotificationComponent
//         notificationType={state.notificationType}
//         notificationMessage={state.notificationMessage}
//       />
//     <div>
//       <br></br>
//       <br></br>
//       <br></br>
//       <center>
//         <Box
//         alignContent="center"
//         sx={{       
//         '& > :not(style)': {
          
//           width: 550,
//           height: 80,},}}>
//         <Paper elevation={3}><br></br>
//       <Typography gutterBottom variant="h4" component="div" fontFamily="monospace">
//           CANTEEN MANAGEMENT SYSTEM 
//         </Typography>
//         </Paper>
//         </Box>
//         <br></br>
//         <br></br>   
//         </center>
//     </div>

//     <div>
//     <Grid container>
//     <Grid xs={2}></Grid>

//     <Grid xs={8}>
//     <Box>
//     <center>

//      <Card sx={{ maxWidth: 550 }}>

//       <CardMedia
//         component="img"
//         alt="canteen illustration"
//         height="150"
//         // image="https://img.freepik.com/free-vector/people-eating-food-court-cafeterias_74855-5284.jpg"
//         image="https://img.freepik.com/premium-vector/cartoon-homeless-people-eating-food-refectory_74855-19723.jpg"
//       />
      
//       <CardContent>
//         {/* <Typography gutterBottom variant="h5" component="div" fontFamily="monospace">
//           LOGIN
//         </Typography>
//                  */}
//                  <br></br>
//       <TextField
//         required
//         id="outlined-required"
//         label="Employee ID"
//         value={user}
//         onChange={(e) => handleText(e)}
//         fullWidth
//       />
//       <br></br>
//       </CardContent>
//       <CardActions>
//       <Grid container justifyContent="center">
//       <Grid item xs={3}>
//       <Button fullWidth variant="contained" onClick={(e) => handleButton(e)}>
//         LOGIN
//       </Button>
//       </Grid>
//     </Grid>    
//       </CardActions>
//       <br></br>    
//       </Card>
//       </center>
// </Box>
// </Grid>

// <Grid xs={2}></Grid>

// </Grid>
// </div>

// <div></div>
//     </>
//   );
// };
// export default Login

import React, { useState } from 'react';
import { TextField, Button, Box, Grid, Paper } from "@mui/material";
import { Card, CardActions, CardContent, CardMedia, Typography } from '@mui/material';
import NotificationComponent from "../commons/notification/notificationComponent";
import { apiToGetEmployeeDetail } from "../../middleware/apiCalls/authApiCall";
import { constructErrorMessage } from "../../helpers/function";
import { RoleCheck } from "../../helpers/function";
import ButtonComponent from '../commons/buttonComponent/buttonComponent';


const Login = () => {
  const [user, setUser] = useState("");
  const [notification, setNotification] = useState({
      notificationType: "",
      notificationMessage: "",
  });

  const handleText = (e) => {
      let u = e.target.value;
      setUser(u);
  };

  const handleButton = async () => {
      if (!user) {
          setNotification({
              notificationType: "warning",
              notificationMessage: "Please enter Employee ID",
          });
          return;
      }

      let result = await apiToGetEmployeeDetail(user);
      if (result && result.status === 200) {
          if (result && result.data.respCode === 200) {
              let details = result.data.respBuffer || {};
              localStorage.setItem("role", details.role_id);
              localStorage.setItem("employId", user);
              localStorage.setItem("firstName", details.first_name);
              localStorage.setItem("lastName", details.last_name);
              localStorage.setItem("emailId", details.email);
              RoleCheck();
          } else {
              setNotification({
                  notificationType: "error",
                  notificationMessage: "Employee doesn't exist",
              });
          }
      }
  };

  
  return (
    <>
      <NotificationComponent
        notificationType={notification.notificationType}
        notificationMessage={notification.notificationMessage}
      />
      <div>
        <br></br>
        <br></br>
        <br></br>
        <center>
          <Box
            alignContent="center"
            sx={{
              '& > :not(style)': {
                width: 550,
                height: 80,
              },
            }}
          >
            <Paper elevation={3}><br></br>
              <Typography gutterBottom variant="h5" component="div" fontFamily="Raleway">
                CANTEEN MANAGEMENT SYSTEM
              </Typography>
            </Paper>
          </Box>
          <br></br>
          <br></br>
        </center>
      </div>

      <div>
        <Grid container>
          <Grid xs={2}></Grid>
          <Grid xs={8}>
            <Box>
              <center>
                <Card sx={{ maxWidth: 550 }}>
                  <CardMedia
                    component="img"
                    alt="canteen illustration"
                    height="150"
                    image="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSUevz1DuGeZoAPh9nD7Md7sZExiG8Itf5lHg&s"
                  />
                  <CardContent>
                    <br></br>
                    <TextField
                      required
                      id="outlined-required"
                      label="Employee ID"
                      value={user}
                      onChange={(e) => handleText(e)}
                      fullWidth
                    />
                    <br></br>
                  </CardContent>
                  <CardActions>
                    <Grid container justifyContent="center">
                      <Grid item xs={5}>
                        <ButtonComponent fullWidth  handleChange={(e) => handleButton(e)} color='success' label={"LOGIN"} style={{ height: "40px", margin: "0%" }}>
                          LOGIN
                        </ButtonComponent>
                      </Grid>
                    </Grid>
                  </CardActions>
                  <br></br>
                </Card>
              </center>
            </Box>
          </Grid>
          <Grid xs={2}></Grid>
        </Grid>
      </div>
    </>
  );
};

export default Login;

