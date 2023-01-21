import { useEffect, useState } from "react";
import { Link, useNavigate } from "react-router-dom";

const AdminUsers=()=>{
    const [empdata, empdatachange] = useState(null);
    const navigate = useNavigate();

    const LoadDetail = (id) => {
        navigate("/edit/" + id);
    }
    const editUser=(id)=>{
        navigate(`/edit/users/${id}`)
    }
    useEffect(() => {
        fetch("http://localhost:9001/api/v6/signin").then((res) => {
            return res.json();
        }).then((resp) => {
            empdatachange(resp);
        }).catch((err) => {
            console.log(err.message);
        })
    }, [])
    
    return(
        <div className="container">
        <div className="card">
            <div className="card-title">
                <h2>Users Listing</h2>
            </div>
            <div className="card-body">
                <div className="divbtn">
                    <Link to="/adduser" className="btn btn-info">Add New</Link>
                </div>
                <table className="table table-bordered">
                    <thead className="bg-dark text-white">
                        <tr>
                            <td>ID</td>
                            <td>Name</td>
                            <td>UserName</td>
                            <td>Email</td>
                            <td>Password</td>
                            <td>Role</td>
                            <td>Edit</td>
                            
                        </tr>
                    </thead>
                    <tbody>

                        {empdata &&
                            empdata.map(item => (
                                <tr key={item.id}>
                                    <td>{item.id}</td>
                                    <td>{item.name}</td>
                                    <td>{item.username}</td>
                                    <td>{item.email}</td>
                                    <td>{item.password}</td>
                                    <td>{item.role}</td>
                                    
                                    <td><button onClick={()=>editUser(item.id)} className='btn btn-info'>Edit</button></td>
                                </tr>
                            ))
                        }

                    </tbody>

                </table>
            </div>
        </div>
    </div>
    )
}

export default AdminUsers;