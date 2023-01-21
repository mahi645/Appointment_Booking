import { useEffect, useState } from "react";
import { Link, useNavigate, useParams } from "react-router-dom";
const EditUser=()=>{
    const { userid } = useParams();

    //const [empdata, empdatachange] = useState({});
    const [id,setid]=useState('');
    const [uname,setuname]=useState('');
    const [pwd,setpassword]=useState('');
    const [name,setname]=useState('');
    const [role,setrole]=useState('');
    const [email,setemail]=useState('');

    
    const navigate=useNavigate();

    const postData=(e)=>{
      e.preventDefault();
      const empdata={id:id,
        name:name,
        username:uname,
        email:email,
        password:pwd,
        role:role};
      

      fetch(`http://localhost:9001/api/v6/update/${id}`,{
        method:"PUT",
        headers:{"Content-Type":"application/json",
                "Access-Control-Allow-Origin":"*"},
        body:JSON.stringify(empdata)
      }).then(response=>response.json())
      .then(json=>console.log(json));
      alert("updated successfully");
      navigate("/admin/users")


    }

    return(
       
        <div id='register'>
        <div id='outer'>
    
        <h3 id="register-heading">Edit Doctor</h3>
            <div className="form-group">
                <label>Id</label>
                <input type="text" className="form-control" placeholder="Enter Id" onChange={(e)=>setid(e.target.value)} />
            </div>
            <div className="form-group">
                <label>Name</label>
                <input type="text" className="form-control" placeholder="Enter name" onChange={(e)=>setname(e.target.value)} />
            </div>
            <div className="form-group">
                <label>Username</label>
                <input type="text" className="form-control" placeholder="Enter Username" onChange={(e)=>setuname(e.target.value)} />
            </div>
            <div className="form-group">
                <label>Email</label>
                <input type="text" className="form-control" placeholder="Enter Email" onChange={(e)=>setemail(e.target.value)}/>
            </div>
            <div className="form-group">
                <label>Role</label>
                <input type="text" className="form-control" placeholder="Enter Role" onChange={(e)=>setrole(e.target.value)} />
            </div>
            <div className="form-group">
                <label>Password</label>
                <input type="password" className="form-control" placeholder="Enter Password" onChange={(e)=>setpassword(e.target.value)} />
            </div>
            
            <div className="form-group">
                <button id="login-submit" type="submit" className="btn btn-dark btn-lg btn-block" onClick={postData}>Submit</button>
            </div>
            <Link to="/admin/doctors" id='link'>Back</Link>

        </div>
    </div>
    )
}
export default EditUser;