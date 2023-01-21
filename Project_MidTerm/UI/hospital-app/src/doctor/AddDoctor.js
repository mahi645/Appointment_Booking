import { useState } from "react";
import {json,Link } from "react-router-dom";
function AddDoctor(){
    
    const [name,setname]=useState('');
    const [uname,setuname]=useState('');
    const [dept,setdept]=useState('');
    const [exper,setexper]=useState('');
    const [pwd,setpwd]=useState('');
    
    const register=()=>{
        alert(name+" "+dept+" "+exper);
        let data={
            name:name,
            username:uname,
            experience:exper,
            department:dept,
            password:pwd
        }
        fetch('http://localhost:9008/api/v1/doctor',{
            method:"POST",
            body:JSON.stringify(data),
            headers:{
                "Content-Type":"application/json",
                "Access-Control-Allow-Origin":"*"
            }
        }).then(response=>response.json())

        .then(json=>console.log(json));
        alert("registerd successfully!!!!!!!!")

    }

    return(
        
        <div id='register'>
        <div id='outer'>
    
        <h3 id="register-heading">Add Doctor</h3>
            <div className="form-group">
                <label>Name</label>
                <input type="text" className="form-control" placeholder="Enter name" onChange={(e)=>setname(e.target.value)} />
            </div>
            <div className="form-group">
                <label>Username</label>
                <input type="text" className="form-control" placeholder="Enter Username" onChange={(e)=>setuname(e.target.value)} />
            </div>
            <div className="form-group">
                <label>Department</label>
                <input type="text" className="form-control" placeholder="Enter Department" onChange={(e)=>setdept(e.target.value)}/>
            </div>
            <div className="form-group">
                <label>Experience</label>
                <input type="text" className="form-control" placeholder="Enter Experience" onChange={(e)=>setexper(e.target.value)} />
            </div>
            <div className="form-group">
                <label>Password</label>
                <input type="password" className="form-control" placeholder="Enter Password" onChange={(e)=>setpwd(e.target.value)} />
            </div>
            
            <div className="form-group">
                <button id="login-submit" type="submit" className="btn btn-dark btn-lg btn-block" onClick={register}>Submit</button>
            </div>
            <Link to="/admin/doctors" id='link'>Back</Link>

        </div>
    </div>
    )
}
export default AddDoctor;