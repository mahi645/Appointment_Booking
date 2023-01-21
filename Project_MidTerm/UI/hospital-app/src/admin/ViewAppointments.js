import { useEffect, useState } from "react";
import { Link, useNavigate } from "react-router-dom";

const ViewAppointments=()=>{
    const [empdata, empdatachange] = useState(null);
    const navigate = useNavigate();

    //http://localhost:9004/api/v3/appointments
    
    useEffect(() => {
        fetch("http://localhost:9003/api/v2/appointments").then((res) => {
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
                <h2 style={{textAlign:'center'}}>Appointments </h2>
            </div>
            <div className="card-body">
                <table className="table table-bordered">
                    <thead className="bg-dark text-white">
                        <tr>
                            <td>ID</td>
                            <td>Patient Name</td>
                            <td>Age</td>
                            <td>Doctor Name</td>
                            <td>Department</td>
                            <td>Problem</td>
                            <td>Appointment Date</td>
                            <td>Appointment time</td>
                        </tr>
                    </thead>
                    <tbody>

                        {empdata &&
                            empdata.map(item => (
                                <tr key={item.id}>
                                    <td>{item.id}</td>
                                    <td>{item.patientName}</td>
                                    <td>{item.age}</td>
                                    <td>{item.nameOfDoctor}</td>
                                    <td>{item.department}</td>
                                    <td>{item.problem}</td>
                                    <td>{item.appointmentDate}</td>
                                    <td>{item.appointmentTime}</td>
                                    
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
export default ViewAppointments;