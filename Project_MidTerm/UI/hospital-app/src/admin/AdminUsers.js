import { useEffect, useState } from "react";
import { Link, useNavigate } from "react-router-dom";

const AdminUsers=()=>{
    const [empdata, empdatachange] = useState(null);
    const navigate = useNavigate();

    const LoadDetail = (id) => {
        navigate(`/view/users/${id}`);
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
                <h2 style={{textAlign:'center'}}>Users Listing</h2>
            </div>
            <div className="card-body">
            
                <table className="table table-bordered">
                    <thead className="bg-dark text-white">
                        <tr>
                            <td>ID</td>
                            <td>Name</td>
                            <td>UserName</td>
                            <td>Email</td>
                            <td>Password</td>
                            <td>Actions</td>
                            
                            
                            
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
                                    <td><button className="btn btn-info" onClick={() => { LoadDetail(item.id) }}>View</button></td>
                                    
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