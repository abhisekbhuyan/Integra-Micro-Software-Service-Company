export const getEmployeeData = (selectedDate) => {
    return `http://localhost:9090/integra/api/employee/finance?date=${selectedDate}`
}

export const downloadExcecl = (date) => {
    return `http://localhost:9090/integra/api/employee/excel?date=${date}`
}
