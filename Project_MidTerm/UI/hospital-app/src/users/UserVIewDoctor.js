import { useEffect, useState } from "react";
import { Link, useNavigate } from "react-router-dom";

const UserViewDoctor=()=>{
    const [empdata, empdatachange] = useState(null);
    const navigate = useNavigate();

    const LoadDetail = (id) => {
        navigate("/edit/" + id);
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
                <table className="table table-bordered">
                    <thead className="bg-dark text-white">
                        <tr>
                            <td>ID</td>
                            <td>Name</td>
                            <td>Department</td>
                            <td>Experience</td> 
                        </tr>
                    </thead>
                    <tbody>

                        {empdata &&
                            empdata.map(item => (
                                <tr key={item.id}>
                                    <td>{item.id}</td>
                                    <td>{item.name}</td>
                                    <td>{item.department}</td>
                                    <td>{item.experience}</td>
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
export default UserViewDoctor;