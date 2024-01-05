import {Button, Input} from "antd";
import {useEffect, useState} from "react";
import {getAllStudents, getUserById, saveStudent} from "../client";
import {useNavigate, useParams} from "react-router-dom";

const EditUser = () => {

    const {id} = useParams();
    const [studs, setStudents] = useState([]);

    const [st, setSt] = useState({
        id:id,
        username:"",
        password:"",
        role:""
    });

    const fetchUserBaseOnId = () => {
        getUserById(id)
            .then(response => setSt(response.data))
    }

    useEffect(()=> {
            fetchUserBaseOnId();
    },[])


    const changeVal = (e) =>{
        e.preventDefault();
        const value = e.target.value;
        const name = e.target.name;
        setSt({...st, [e.target.name]: value});
    }

    const saveStud = (e) => {
        e.preventDefault();
        console.log(st);
        console.log(id)

        saveStudent(st)
            .then(r => {
                    navi("/studentsList");
                }
            )
    }

    const navi = useNavigate();

    const navigate2 = () => {
        setSt( {id:id,
            username:"",
            password:"",
            role:"" })
    }


    return <>


        <h1>EDIT USER</h1>
        <form>
            <Input type="text" name="username" placeholder="Enter your username" value={st.username} onChange={changeVal}/><br/>
            <Input type="text" name="password" placeholder="Enter your password" value={st.password} onChange={changeVal}/><br/>
            <Input type="text" name="role" placeholder="Enter your role" value={st.role} onChange={changeVal}/><br/>
            <Button type="primary" name="submit" id = "sub" onClick={saveStud}>UPDATE</Button>
            <Button type="primary" name="submit" id = "log" onClick = {navigate2}>CLEAR</Button>
        </form>

    </>
}
export default EditUser;