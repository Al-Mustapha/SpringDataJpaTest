import {Button, Input} from "antd";
import './App.css';
import {getAllStudents, saveStudent} from "./client";
import {useEffect, useState} from "react";
import {BrowserRouter, Route, Routes, useNavigate} from "react-router-dom";
import StudentsList from "./Components/StudentsList";
import Login from "./Components/Login";
import Signup from "./Components/Signup";
import EditUser from "./Components/EditUser";



function Root(){

    const navigate = useNavigate();
    const nav = () =>{
        navigate("/studentsList");
    }
    return (
        <div>

            <Routes>
                <Route path="/studentsList" element={<StudentsList/>} ></Route>
                <Route index element={<Signup/>}></Route>
                <Route path="/signup" element={<Signup/>}></Route>
                <Route path="/login" element={<Login/>}></Route>
                <Route path ="/editUser/:id" element={<EditUser/>}></Route>
            </Routes>
        </div>
    )
};

function App() {



    return (
    <div className="App">

        <BrowserRouter>
            <Root/>
        </BrowserRouter>

    </div>
  );
}

export default App;

