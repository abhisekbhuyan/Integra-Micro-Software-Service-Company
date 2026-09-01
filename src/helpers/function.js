import { serverErrorMessage } from "./constant";

//construct error message
export const constructErrorMessage = () => {
  return serverErrorMessage;
};

//based on role redirect to portal
export const RoleCheck = () => {
  let roleKey = localStorage.getItem("role");
  if (roleKey === "2") {
    window.location.href = "/support";
  } else if (roleKey === "3") {
    window.location.href = "/hr";
  } else if (roleKey === "4") {
    window.location.href = "/finance";
  } else {
    window.location.href = "/roleNotfound";
  }
};

//close session
export const CloseSession = () => {
  localStorage.removeItem("role");
  localStorage.removeItem("employId");
  localStorage.removeItem("firstName");
  localStorage.removeItem("lastName");
  localStorage.removeItem("emailId");
  window.location.href = "/login";
};