import { useEffect, useState } from "react";
import { Link, useNavigate,useParams } from "react-router-dom";
const Doctor1=()=>{
    const [user, empdatachange] = useState(null);
    const navigate = useNavigate();
    const {id}=useParams();
    useEffect(() => {
        fetch(`http://localhost:9008/api/v1/doctor1/${id}`).then((res) => {
            return res.json();
        }).then((resp) => {
            empdatachange(resp);
        }).catch((err) => {
            console.log(err.message);
        })
    }, [])
    return(
        <div className="container">
        <div className="row">
          <div className="col-md-6 offset-md-3 border rounded p-4 mt-2 shadow">
            <h2 className="text-center m-4">Doctor Details</h2>
  
            <div className="card">
              <div className="card-header">
                Details of Doctor id : {user.id}
                <ul className="list-group list-group-flush">
                  <li className="list-group-item">
                    <b>Name:</b>
                    {user.name}
                  </li>
                  <li className="list-group-item">
                    <b>UserName:</b>
                    {user.username}
                  </li>
                  <li className="list-group-item">
                    <b>Department:</b>
                    {user.department}
                  </li>
                  <li className="list-group-item">
                    <b>Experience:</b>
                    {user.experience}
                  </li>
                </ul>
              </div>
            </div>
            <Link className="btn btn-primary my-2" to={"/admin/doctors"}>
              Back to Home
            </Link>
          </div>
        </div>
      </div>
    );
}
export default Doctor1;