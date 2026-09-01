import React, { Fragment } from "react";
import PortalNotFound from "../../pages/login/portalNotFound";

const Authentication = ({ children }) => {
  
  const checkAuth = () => {
    let roleKey = localStorage.getItem("role");
    if (roleKey) {
      return <Fragment>{children}</Fragment>;
    } else {
      return <PortalNotFound />;
    }
  };

  return <>{checkAuth()}</>;
};
export default Authentication;
