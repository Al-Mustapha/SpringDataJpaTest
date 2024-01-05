import {Button, Input} from "antd";
import {useNavigate} from "react-router-dom";
import {authenticateUsrer, getAllStudents, getStudentBaseOnUsername} from "../client";
import {useEffect, useState} from "react";

const Login = () => {

   const navigate = useNavigate();

   const [message, setMessage] = useState("");

   const nav = () => {
       navigate("/signup");
   }

   const [userDetails, setUserDetails] = useState({
       username:"",
       password:""
   });

    const handleChange = (e) => {
        const x = e.target.value;
        setUserDetails({...userDetails, [e.target.name]:x});
    }

   const [status, setStatus] = useState(0);

   const getDetails = () => {
      authenticateUsrer(userDetails.username, userDetails.password)
           .then(response => setStatus(response.status))
           .catch(error => console.log(error));

    if (status == 200) {
        setMessage("Login Successfully");
        navigate("/studentsList");
    }
    else
           setMessage("Username or Password Incorrect");
   }

    // const [st, setSt] = useState([]);
    //
    // const fetAllStudents = () => {
    //     const logger = userDetails.username;
    //     getStudentBaseOnUsername(logger)
    //         .then(response => response.json())
    //         .then(data => setSt(data));
    // }
    //
    // useEffect(()=>{
    //     fetAllStudents();
    // },[]);

    return (

    <div className="Login">

        <h1>LOGIN TO TOUR</h1>
        <form>
        <label>{message}</label><br/><br/>
        <Input type = "text" placeholder = "Enter your username" name = "username" id = "username" value = {userDetails.username} onChange = {handleChange}/><br/>
        <Input type = "text" placeholder = "Enter your password" name = "password" id = "password" value = {userDetails.password} onChange = {handleChange}/><br/>
        <Button type = "submit" name = "submit" id = "sub1" onClick = {getDetails}>LOGIN</Button>
        <Button type = "submit" name = "submit" id = "log1" onClick = {nav}>SIGN UP</Button>
        </form>
    </div>
    )
}
export default Login;