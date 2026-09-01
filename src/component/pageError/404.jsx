
import React from "react";
import { Button } from "@mui/material";

const redirectBack = () => {
    window.location.href = "/login";
  };


const Error=()=>{
return(
    <>
    <body background-color="blue">
    <div>
        
        <center>
        
        
        <marquee behavior="scroll" direction="left"><h3>404 - Oops! Page not found</h3></marquee>
        <img height={400} width={400}  src="https://cdn3d.iconscout.com/3d/premium/thumb/girl-facing-404-error-7181369-5841594.png" alt="404 - THIS PAGE IS NOT FOUND"> 
        </img>  
        <h3> - THE PAGE YOU ARE LOOKING FOR DOESN'T EXIST - </h3>
        
        <Button variant="contained" onClick={(e) => redirectBack(e)}>
        REDIRECT TO LOGIN PAGE
      </Button>
      
      <br></br>

        </center>
    </div>
    </body>
    </>
)
}
export default Error;