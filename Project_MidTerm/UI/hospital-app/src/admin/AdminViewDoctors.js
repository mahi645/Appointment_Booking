import { useEffect, useState } from "react";
import { Link, useNavigate } from "react-router-dom";

const AdminViewDoctors=()=>{
    const [empdata, empdatachange] = useState(null);
    const navigate = useNavigate();

    const LoadDetail = (id) => {
        navigate("/edit/" + id);
    }
    const LoadEdit = (id) => {
        navigate("/edit/" + id);
    }
    const Removefunction = (id) => {
        if (window.confirm('Do you want to remove?')) {
            fetch("http://localhost:9008/api/v1/doctor/" + id, {
                method: "DELETE"
            }).then((res) => {
                alert('Removed successfully.')
                window.location.reload();
            }).catch((err) => {
                console.log(err.message)
            })
        }
    }




    useEffect(() => {
        fetch("http://localhost:9008/api/v1/doctors").then((res) => {
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
                <h2>Doctors Listing</h2>
            </div>
            <div className="card-body">
                <div className="divbtn">
                    <Link to="/add/doctors" className="btn btn-info">Add New</Link>
                </div>
                <table className="table table-bordered">
                    <thead className="bg-dark text-white">
                        <tr>
                            <td>ID</td>
                            <td>Name</td>
                            <td>Username</td>
                            <td>Department</td>
                            <td>Experience</td>
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
                                    <td>{item.department}</td>
                                    <td>{item.experience}</td>
                                    <td>{item.password}</td>
                                    
                                    <td><button id="#btn" className="btn btn-primary " onClick={() => { LoadEdit(item.id) }}>Edit</button>
                                    <button className="btn btn-success" onClick={() => { Removefunction(item.id) }}>Delete</button></td>
                                    
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
export default AdminViewDoctors;