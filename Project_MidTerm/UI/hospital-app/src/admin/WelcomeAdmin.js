import React, { useState } from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';  
import { Navbar, Container, Nav, NavDropdown, NavItem } from 'react-bootstrap';
import welcome from '../images/welcome.jpg';
function WelcomeAdmin(){
return(
    
        <div id='user-main'>
        <Navbar collapseOnSelect expand="xl" bg="dark" variant="dark" id="navbar-user">  
    
        <div className='container' id="nav-user" style={{height:56}}>
          <Navbar.Brand href="#home">Sreenithya Health Care</Navbar.Brand><br/>  
          <Navbar.Toggle aria-controls="responsive-navbar-nav" />  
          <Navbar.Collapse id="responsive-navbar-nav">  
            <Nav className="me-auto">  
                
                <NavItem>Hello User</NavItem>
                
            </Nav>  
            <Nav>  
                <Nav.Link href='/admin/doctors'>Doctors</Nav.Link>
                <Nav.Link href='/admin/users'>Users</Nav.Link>
                <Nav.Link href='/user/appointments'>Appointments</Nav.Link>
                <Nav.Link href="/welcome">Sign out</Nav.Link>  
               
               
            </Nav>  
          </Navbar.Collapse>  
          
          
    
        </div>
        
      </Navbar>
      <div style={{display:'block'}} id="user-body">
      <img style={{height:843}}  src={welcome} 
                alt=''/>
    </div>
    </div>

)
}
export default WelcomeAdmin;