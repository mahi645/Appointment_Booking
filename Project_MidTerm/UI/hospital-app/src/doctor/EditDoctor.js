import { useEffect, useState } from "react";
import { Link, useNavigate, useParams } from "react-router-dom";
const EditDoctor=()=>{
    const { userid } = useParams();

    //const [empdata, empdatachange] = useState({});
    const [id,setid]=useState('');
    const [uname,setuname]=useState('');
    const [pwd,setpassword]=useState('');
    const [name,setname]=useState('');
    const [department,setdepartment]=useState('');
    const [experience,setexperience]=useState('');

    
    const navigate=useNavigate();

    const postData=(e)=>{
      e.preventDefault();
      const empdata={id:id,
        name:name,
        username:uname,
        department:department,
        password:pwd,
        experience:experience};
      

      fetch(`http://localhost:9008/api/v1/update/${id}`,{
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
                <label>Department</label>
                <input type="text" className="form-control" placeholder="Enter Department" onChange={(e)=>setdepartment(e.target.value)}/>
            </div>
            <div className="form-group">
                <label>Experience</label>
                <input type="text" className="form-control" placeholder="Enter Experience" onChange={(e)=>setexperience(e.target.value)} />
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
export default EditDoctor;