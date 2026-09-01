export const getAllEmployeeDetails=(date)=>{
    return`http://localhost:9090/integra/api/employee/hr?date=${date}`
}

export const getEmployeeDetailsById=(date,empId)=>{
    return`http://localhost:9090/integra/api/employee/employeeCanteenDetails?emp_id=${empId}&date=${date}`
}

export const updateEmployeeDetails=(empId)=>{
    return`http://localhost:9090/integra/api/employee/${empId}`
}