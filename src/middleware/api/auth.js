
//1. login
export const login=(id)=>{
    return `http://localhost:9090/integra/api/employee/validate/${id}`
}

export const submitCateenData = () => {
    return `http://localhost:9090/integra/api/employee/create`
}