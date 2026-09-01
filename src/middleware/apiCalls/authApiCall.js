import { apiGetMethod } from "../middleware"
import { login } from "../api/auth"
import {apiPostMethod} from "../middleware"
import {submitCateenData} from "../api/auth"

export const apiToGetEmployeeDetail = async (id) => {
    const result = await apiGetMethod(login(id));
    return result;
}

export const apiToSubmitCateenData=async(payload)=>{
    let result = await apiPostMethod(submitCateenData(),payload)
    return result;

}