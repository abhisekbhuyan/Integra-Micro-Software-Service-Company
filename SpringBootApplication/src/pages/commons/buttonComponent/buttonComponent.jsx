import React from "react";
import { Button } from "@mui/material";

const ButtonComponent =({
id,
name,
label,
handleChange,
color

}) => {
    return (
        <Button
        id={id}
        name={name}     
        onClick={handleChange}
        // style={{ height: "40px", margin: "0%", width: "100%" }}
        color={color}
        variant="contained"
        >
            
        {label}
        </Button>

        
    )}


export default ButtonComponent;

