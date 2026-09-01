import React from "react";
import Navbar from "../navbar/navbar";
import { Outlet } from "react-router";
import Footer from "../footer/footer";

const Layout = ({ children }) => {
    return (
        <>
            <Navbar />
            <br></br>
            {children || <Outlet />}
            <br></br>
            <Footer/>
        </>
    )
}
export default Layout;