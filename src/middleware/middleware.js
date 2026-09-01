import axios from "axios";

//Get Method
const apiGetMethod = async (url) => {
     return axios
    .get(url, {
      headers: {
        "Content-Type": "application/json",
        "token":""
      },
      data: {},
    })
    .then((res) => {
      return res;
    })
    .catch((error) => {
      return error.response;
    });
};

//Post Method
const apiPostMethod = async (url, payload) => {
 return axios
    .post(url, payload, {
      headers: {
        "Content-Type": "application/json",
      },
      data: {},
    })
    .then((res) => {
      return res;
    })
    .catch((error) => {
      return error.response;
    });
};

//Put Method
const apiPutMethod = async (url, payload) => {
  return axios
    .put(url, payload, {
      headers: {
        "Content-Type": "application/json",
      },
      data: {},
    })
    .then((res) => {
      return res;
    })
    .catch((error) => {
      return error.response;
    });
};

//Delete Method
const apiDeleteMethod = async (url) => {
  return axios
    .delete(url, {
      headers: {
        "Content-Type": "application/json",
      },
      data: {},
    })
    .then((res) => {
      return res;
    })
    .catch((error) => {
      return error.response;
    });
};



export { apiGetMethod, apiPostMethod, apiDeleteMethod, apiPutMethod };
