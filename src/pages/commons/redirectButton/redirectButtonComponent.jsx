import React from "react";
import { Button } from "@mui/material";
const RedirectButtonComponent = () => {

    const redirectBack = () => {
        window.location.href = "/login";
      };
    
  return (
    <>
      <Button
        variant="contained"
        className="buttonPrimaryColor"
        style={{ height: "40px", margin: "0%", width: "40%" }}
        onClick={(e) => redirectBack(e)}
        color="secondary"
      >
        REDIRECT BACK TO LOGIN PAGE
      </Button>
    </>
  );
};
export default RedirectButtonComponent;
