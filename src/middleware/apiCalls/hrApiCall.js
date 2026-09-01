import { apiGetMethod, apiPutMethod } from "../middleware"
import { getAllEmployeeDetails, getEmployeeDetailsById, updateEmployeeDetails } from "../api/hr"

export const apiToGetAllEmployeeDetails = async (date) => {
    let result = await apiGetMethod(getAllEmployeeDetails(date))
    return result;
}

export const apiToGetEmployeeDetailsById = async (date, empId) => {
    let result = await apiGetMethod(getEmployeeDetailsById(date, empId))
    return result;
}

export const apiToUpdateEmployeeDetails = async (empId,payload) => {
    let result = await apiPutMethod(updateEmployeeDetails(empId),payload)
    return result;
}