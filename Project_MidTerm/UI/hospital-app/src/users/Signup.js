import { useState } from "react";
import {json,Link } from "react-router-dom";
function Signup(){
    const [uname,setuname]=useState('');
    const [pwd,setpassword]=useState('');
    const [name,setname]=useState('');
    const [role,setrole]=useState('');
    const [email,setemail]=useState('');
    
    const register=()=>{
        alert(uname+" "+pwd);
        let data={
            name:name,
            username:uname,
            email:email,
            password:pwd,
            role:role
        }
        fetch('http://localhost:9001/api/v6/signup',{
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
    
        <h3 id="register-heading">Login</h3>
            <div className="form-group">
                <label>Name</label>
                <input type="text" className="form-control" placeholder="Enter name" onChange={(e)=>setname(e.target.value)} />
            </div>
            <div className="form-group">
                <label>Username</label>
                <input type="text" className="form-control" placeholder="Username" onChange={(e)=>setuname(e.target.value)}/>
            </div>
            <div className="form-group">
                <label>Password</label>
                <input type="password" className="form-control" placeholder="Enter password" onChange={(e)=>setpassword(e.target.value)} />
            </div>
            <div className="form-group">
                <label>Email</label>
                <input type="email" className="form-control" placeholder="Email" onChange={(e)=>setemail(e.target.value)} />
            </div>
            <div className="form-group">
                <label>Role</label>
                <input type="text" className="form-control" placeholder="Enter role" onChange={(e)=>setrole(e.target.value)} />
            </div>
            <div className="form-group">
                <button id="login-submit" type="submit" className="btn btn-dark btn-lg btn-block" onClick={register}>Submit</button>
            </div>
            <Link to="/login" id='link' >Already a member?Login</Link>

        </div>
    </div>
    )
}
export default Signup;