import React from "react";
import { Button, Grid, Card } from "@mui/material";
import RedirectButtonComponent from "../commons/redirectButton/redirectButtonComponent"

const RoleNotFound = () => {

  const redirectBack = () => {
    window.location.href = "/login";
  };

  return (
    <>
     <Grid container>
        <Grid item xs={1}></Grid>

        <Grid item xs={10}>
  <Card style={{padding:"3%"}}>
<center>
  <h3>HELLO USER, <br></br> NO PAGE EXISTS FOR THIS ROLE, PLEASE CHECK WITH ADMIN.</h3>
  
  <img height={250} width={350}  src="https://cdn3d.iconscout.com/3d/premium/thumb/search-not-found-5342748-4468820.png?f=webp" alt="403 - ACCESS DENIED"></img>
  <br></br>
      
    <RedirectButtonComponent>
    REDIRECT TO LOGIN PAGE
    </RedirectButtonComponent>
  </center>
  
   </Card>
  </Grid>

  <Grid item xs={1}></Grid>
  </Grid>    

    </>
  );
};
export default RoleNotFound;

