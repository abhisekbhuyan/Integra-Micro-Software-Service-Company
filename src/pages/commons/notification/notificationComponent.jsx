import React from "react";
import { useEffect } from "react";
import {
  NotificationManager,
  NotificationContainer,
} from "react-notifications";
import "react-notifications/lib/notifications.css";

const NotificationComponent = ({
  notificationType,
  notificationMessage,
}) => {
  useEffect(() => {
    callNotification();
  }, [notificationType]);

  const callNotification = () => {
  //  let notificationArray=NotificationManager.listNotify
  //   if(notificationArray.length!==0){
  //     let index=notificationArray.findIndex(function(item, i){
  //       return item.title === notificationHeader
  //     });
  //     if(index!==-1){
  //       let id=notificationArray[index].id
  //       NotificationManager.remove({ id: id })
  //     }
  //   }
    if (notificationType === "info") {
      return NotificationManager.info("Info message");
    } else if (notificationType === "success") {
      return NotificationManager.success(
        `${notificationMessage || ""}`,
        `Success`,
        3000
      );
    } else if (notificationType === "warning") {
      return NotificationManager.warning(
        "Warning message",
        `${notificationMessage || ""}`,
        3000
      );
    } else if (notificationType === "error") {
      return NotificationManager.error(
        `${notificationMessage || ""}`,
        "Error",
        3000
      );
    }
  };

  return (
    <>
      <NotificationContainer />
    </>
  );
};

export default NotificationComponent;
