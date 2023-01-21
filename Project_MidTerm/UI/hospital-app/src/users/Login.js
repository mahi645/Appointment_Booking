import { useState } from 'react';
import {Link,useNavigate} from 'react-router-dom'
function Login(){
    // const history = useHistory();
    const navigate = useNavigate();
    const [uname,setuname]=useState('');
    const [pwd,setpwd]=useState('');
    const validate=()=>{
        if(uname==""||pwd==""){
            alert("Fill Credentials")
        }
        let data={
            username:uname,
            password:pwd
        }
        fetch('http://localhost:9001/api/v6/validate',{
            method:"POST",
            body:JSON.stringify(data),
            headers:{
                "Content-Type":"application/json",
                "Access-Control-Allow-Origin":"*"
            }
        }).then(response=>{return response.text();})
        .then((text)=>{
            if(text=='valid'){
                alert("login successful");
                // pathchg(history);
                navigate('/welcome/user');
            }
            else{
                alert("please verify credentials")
            }
        })
    }
    // const pathchg=(history)=>{
    //     let path = `/home`; 
    //     history.push(path);
    // }
    return(
        // <>
        // <h2>login</h2>
        // <Link to="/home" >Home</Link>
        // <Link to="/Signup" >Signup Here</Link>

        // </>
         <div id='register'>
            <div id='outer'>
        
            <h3 id="register-heading">Login</h3>

        <div className="form-group">
            <label>Username</label>
            <input type="text" className="form-control" placeholder="Username" onChange={(e)=>setuname(e.target.value)}/>
        </div>

        <div className="form-group">
            <label>Password</label>
            <input type="password" className="form-control" placeholder="Enter password" onChange={(e)=>setpwd(e.target.value)} />
        </div>
        <div className="form-group">
        <button id="login-submit" type="submit" className="btn btn-dark btn-lg btn-block" onClick={validate}>Submit</button>
        </div>
        <Link to="/signup" id='link' >Not a member?Signup Here</Link>
    
    </div>
    </div>
    )
}
export default Login;
