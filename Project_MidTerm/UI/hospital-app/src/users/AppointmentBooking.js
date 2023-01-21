import { useEffect, useState } from "react";
import { Form } from "react-bootstrap";
import Select from 'react-select';
const  AppointmentBooking=()=>{
    const [empdata, empdatachange] = useState(null);
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
        <div>{empdata && empdata.map(item=>(
            <Select options={item.name}/>
            ))
        }
            
        </div>
    )
}
export default AppointmentBooking;