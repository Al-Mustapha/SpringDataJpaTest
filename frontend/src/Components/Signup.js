import {Button, Input} from "antd";
import {useState} from "react";
import {saveStudent} from "../client";
import {useNavigate} from "react-router-dom";

const Signup = () =>{

    const [studs, setStudents] = useState([]);

    const [st, setSt] = useState({
        id:"",
        username:"",
        password:"",
        role:""
    });


    const changeVal = (e) =>{
        e.preventDefault();
        const value = e.target.value;
        const name = e.target.name;
        setSt({...st, [e.target.name]: value});
    }

    const saveStud = (e) => {
        e.preventDefault();
        console.log(st);
        saveStudent(st)
            .then(r => console.log(r))
            .catch(error => console.log(error));
    }

    const navi = useNavigate();

    const navigate2 = () => {
        navi("/login");
    }


    return <>

        <h1>SIGN UP TO TOUR</h1>
        <form>
            <Input type="text" name="username" placeholder="Enter your username" value={st.username} onChange={changeVal}/><br/>
            <Input type="text" name="password" placeholder="Enter your password" value={st.password} onChange={changeVal}/><br/>
            <Input type="text" name="role" placeholder="Enter your role" value={st.role} onChange={changeVal}/><br/>
            <Button type="primary" name="submit" id = "sub" onClick={saveStud}>SIGN UP</Button>
            <Button type="primary" name="submit" id = "log" onClick = {navigate2}>LOGIN</Button>
        </form>



    </>
}
export default Signup;