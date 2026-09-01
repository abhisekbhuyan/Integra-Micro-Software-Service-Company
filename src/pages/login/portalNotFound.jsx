import React from "react";
import { Box, Button, Paper } from "@mui/material";
import RedirectButtonComponent from "../commons/redirectButton/redirectButtonComponent"

const PortalNotFound = () => {
  
  const redirectBack = () => {
    window.location.href = "/login";
  };

  return (
    <>
    <div><br></br><br></br></div>

    <div>
      <center>
      <Box
      sx={{        
        '& > :not(style)': {
          m: 1,
          width: 800,
          height: 120,
        },
      }}
    >
    <Paper  elevation={2}>
      <br></br>
      <h3>HELLO USER, <br></br> YOU DON'T HAVE ACCESS TO THIS PAGE, AS IT ISN'T A VALID SESSION.</h3>
      
      </Paper>
      </Box>
      
      <img height={300} width={400}  src="https://cdni.iconscout.com/illustration/premium/thumb/access-denied-7345129-5913495.png" alt="403 - ACCESS DENIED"></img>
      </center>
      </div>

      <div>
        <center>      
        <RedirectButtonComponent>
        REDIRECT TO LOGIN PAGE
        </RedirectButtonComponent>
      <br></br>
      </center>
      </div>


    </>
  );
};
export default PortalNotFound;
