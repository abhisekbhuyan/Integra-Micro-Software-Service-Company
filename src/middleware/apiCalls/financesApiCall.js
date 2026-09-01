import {apiGetMethod} from "../middleware";
import {getEmployeeData,downloadExcecl} from "../api/finance";

export const apiToGetEmployeeCanteenData=async(selectedDate)=>{
    let result = await apiGetMethod(getEmployeeData(selectedDate))
    return result;
}

export const apiToDownloadExcel=async(date)=>{
    let result = await apiGetMethod(downloadExcecl(date))
    return result;
}