import logo from './logo.svg';
import './App.css';
import {Routes,Route,BrowserRouter} from 'react-router-dom';
import Welcome from './Welcome';
import Login from './users/Login'
import Signup from './users/Signup';
import WelcomeUser from './users/WelcomeUser';
import AdminViewDoctors from './admin/AdminViewDoctors';
import AddDoctor from './doctor/AddDoctor';
import UserViewDoctor from './users/UserVIewDoctor';
import WelcomeDoctor from './doctor/WelcomeDoctor';
import WelcomeAdmin from './admin/WelcomeAdmin';
import AdminUsers from './admin/AdminUsers';
import EditUser from './users/EditUser';
import AppointmentBooking from './users/AppointmentBooking';
import EditDoctor from './doctor/EditDoctor';
import AdminLogin from './admin/AdminLogin';
import DoctorLogin from './doctor/DoctorLogin';


function App() {
  return (
    
         <>
         <BrowserRouter>
          <Routes>
            <Route path="/welcome" element={<Welcome/>}> </Route>
            <Route path="/user/login" element={<Login/>}> </Route>
            <Route path="/signup" element={<Signup/>}> </Route>
            <Route path="/welcome/user" element={<WelcomeUser/>}> </Route>
            <Route path="/admin/doctors" element={<AdminViewDoctors/>}> </Route>
            <Route path="/add/doctors" element={<AddDoctor/>}> </Route>
            <Route path="/user/doctors" element={<UserViewDoctor/>}> </Route>
            <Route path="/welcome/doctors" element={<WelcomeDoctor/>}> </Route>
            <Route path="/welcome/admin" element={<WelcomeAdmin/>}> </Route>
            <Route path="/admin/users" element={<AdminUsers/>}> </Route>
            <Route path="/edit/users/:id" element={<EditUser/>}> </Route>
            <Route path='/appoointment' element={<AppointmentBooking/>}></Route>
            <Route path='/edit/doctor:id' element={<EditDoctor/>}></Route>
            <Route path='/admin/login' element={<AdminLogin/>}></Route>
            <Route path='/doctor/login' element={<DoctorLogin/>}></Route>
          </Routes>
         </BrowserRouter>
         </>
  );
}

export default App;
