import { useEffect, useState } from "react";
import { Link, useNavigate, useParams } from "react-router-dom";
const AppointmentBooking=()=>{
    //const { userid } = useParams();

    //const [empdata, empdatachange] = useState({});
    //const [id,setid]=useState('');
    const [patientName,setpatientName]=useState('');
    const [problem,setproblem]=useState('');
    const [nameOfDoctor,setnameofDoctor]=useState('');
    const [department,setdepartment]=useState('');
    const [appointmentDate,setappointmentDate]=useState('');
    const [appointmentTime,setappointmentTime]=useState('');
    const [age,setage]=useState('');

    
    const navigate=useNavigate();

    const postData=(e)=>{
      e.preventDefault();
      const empdata={
        patientName:patientName,
        nameOfDoctor:nameOfDoctor,
        department:department,
        problem:problem,
        appointmentDate:appointmentDate,
        appointmentTime:appointmentTime,
        age:age
      };

      fetch(`http://localhost:9004/api/v3/appointment/${nameOfDoctor}/${department}`,{
        method:"POST",
        headers:{"Content-Type":"application/json",
                "Access-Control-Allow-Origin":"*"},
        body:JSON.stringify(empdata)
      }).then(response=>response.json())
      .then(json=>console.log(json));
      alert(" Booking Appointment successfully");
      navigate("/welcome/user")


    }
   

    return(
       
        <div id='register'>
        <div id='outer'>
    
        <h3 id="register-heading">Book Appointment</h3>
            <div className="form-group">
                <label>Name of Patient</label>
                <input type="text" className="form-control" placeholder="Enter Name Of Patient" onChange={(e)=>setpatientName(e.target.value)} />
            </div>
            <div className="form-group">
                <label>Age</label>
                <input type="text" className="form-control" placeholder="Enter Age" onChange={(e)=>setage(e.target.value)} />
            </div>
            <div className="form-group">
                <label>Name Of Doctor</label>
                <input type="text" className="form-control" placeholder="Enter Name Of Doctor" onChange={(e)=>setnameofDoctor(e.target.value)} />
            </div>
            <div className="form-group">
                <label>Department</label>
                <input type="text" className="form-control" placeholder="Enter Department" onChange={(e)=>setdepartment(e.target.value)} />
            </div>
            
            <div className="form-group">
                <label>Problem</label>
                <input type="text" className="form-control" placeholder="Enter problem" onChange={(e)=>setproblem(e.target.value)} />
            </div>
            <div className="form-group">
                <label>Appointment Date</label>
                <input type="text" className="form-control" placeholder="yyyy-mm-dd" onChange={(e)=>setappointmentDate(e.target.value)}/>
            </div>
            <div className="form-group">
                <label>Appointment Time</label>
                <input type="text" className="form-control" placeholder="hh:mm:ss" onChange={(e)=>setappointmentTime(e.target.value)} />
            </div>
           
            
            <div className="form-group">
                <button id="login-submit" type="submit" className="btn btn-dark btn-lg btn-block" onClick={postData}>Submit</button>
            </div>
            <Link to="/admin/doctors" id='link'>Back</Link>

        </div>
    </div>
    )
}
export default AppointmentBooking;