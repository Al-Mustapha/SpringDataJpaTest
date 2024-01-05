import {deleteStudentById, getAllStudents, saveStudent} from "../client";
import {useEffect, useState} from "react";
import {Button} from "antd";
import {useNavigate} from "react-router-dom";

const StudentsList = () => {
    const [studs, setStudents] = useState([]);
    const [loading, setLoading] = useState(false);

    const navigate = useNavigate();

    const fetchStudents = () => {
        getAllStudents()
            .then(response => response.json())
            .then(data => setStudents(data))
    }

    useEffect(()=>{
        fetchStudents();

    },[]);


    // const columns = [{
    //    title:'Student Id',
    //     dataIndex:'id',
    //     key:'id'
    // },
    //     {
    //         title:'Username',
    //         dataIndex:'username',
    //         key:'username'
    //     },
    //     {
    //         title:'Password',
    //         dataIndex:'password',
    //         key:'password'
    //     },
    //     {
    //         title:'Role',
    //         dataIndex:'role',
    //         key:'role'
    //     },
    //     {
    //         title:'',
    //         dataIndex:'edit',
    //         key:'edit'
    //     },
    //     {
    //         title:'',
    //         dataIndex:'delete',
    //         key:'delete'
    //     },
    //
    // ]

    const deleteStudent = (id) => {
        deleteStudentById(id)
        .then((response) => {
            if (studs) {
                setStudents((prevState) => {
                    return prevState.filter(stu => stu.id !== id);
                })
            }
        })
            .catch(error => console.log(error));

        return "Successfully deleted"
   }

   const updateStudent = (id) => {
       navigate("/editUser/" + id);
       fetchStudents();
   }

    return (
    <div className="studentsList">
        <Button type = "primary" onClick={() => navigate("/signup")}>ADD USER</Button>

        <h1>STUDENTS LIST</h1>

        {/*<Table dataSource = {studs} columns = {columns} name = "antd" rowKey = "id" />*/}



        <table border="1" align="center">
            <thead>
            <tr>
                <th>Student id</th>
                <th>Username</th>
                <th>Password</th>
                <th>Role</th>
                <th></th>
                <th></th>
            </tr>
            </thead>

            <tbody>
            {studs.map((stud,index)=>
            <tr key={index}>
                <td>{stud.id}</td>
                <td>{stud.username}</td>
                <td>{stud.password}</td>
                <td>{stud.role}</td>
                <td><Button onClick={() => updateStudent(stud.id)}>Edit</Button></td>
                <td><Button onClick={() => deleteStudent(stud.id)}>Delete</Button></td>
            </tr>
                )}
            </tbody>
        </table>
    </div>
    )
}
export default StudentsList;