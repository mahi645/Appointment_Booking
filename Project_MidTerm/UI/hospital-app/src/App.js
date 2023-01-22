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
import DoctorLogin from './doctor/DoctorLogin';
import AdminLogin from './admin/AdminLogin';
import ViewAppointments from './admin/ViewAppointments';
import ViewDoctor from './doctor/ViewDoctor'
import ViewUsers from './users/ViewUsers';
import About from './admin/About';
import Doctor from './doctor/Doctor';
import Doctor1 from './doctor/Doctors1';

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
            <Route path='/edit/doctor/:id' element={<EditDoctor/>}></Route>
            <Route path="/doctor/login" element={<DoctorLogin/>}> </Route>
            <Route path='/admin/login' element={<AdminLogin/>}></Route>
            <Route path='/book/appointment/:nameOfDoctor/:department' element={<AppointmentBooking/>}></Route>
            <Route path='/view/appointments' element={<ViewAppointments/>}></Route>
            <Route path='/view/doctor/:id' element={<ViewDoctor/>}></Route>
            <Route path='/view/users/:id' element={<ViewUsers/>}></Route>
            <Route path='/about' element={<About/>}></Route>
            <Route path='/doctor/doctors' element={<Doctor/>}></Route>
            <Route path='/doctor1/:id' element={<Doctor1/>}></Route>

          </Routes>
         </BrowserRouter>
         </>
  );
}

export default App;
