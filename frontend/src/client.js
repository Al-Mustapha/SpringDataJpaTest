import axios from "axios";

const checkStatus = (response) => {
    if(response.ok){
        return response;
    }
    else {
        const error = new Error(response.statusText)
        error.response = response;
        return Promise.reject(error);
    }
}

export const getAllStudents = () =>
    fetch("http://localhost:8082/getUsers")
        .then(checkStatus);

export const saveStudent = (UserModel) =>
    axios.post("http://localhost:8082/saveUser", UserModel);

export const getStudentBaseOnUsername = (username) =>
    fetch("http://localhost:8082/getUserByUsername/" + username)
        .then(checkStatus);

export const authenticateUsrer = (username, password) =>
    axios.post("http://localhost:8082/authenticate",{
        username: username, password: password
    });

export const deleteStudentById = (id) =>
    axios.delete("http://localhost:8082/deleteStudent/" + id);

export const updateUserById = (id, student) =>
    axios.put("http://localhost:8082/updateStudent/" + id, {
        student
    })

export const getUserById = (id) =>
    axios.get("http://localhost:8082/getUserById/" + id);




