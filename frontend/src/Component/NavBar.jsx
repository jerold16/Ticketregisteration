import React from 'react'
import { Link, useNavigate } from 'react-router-dom'
import "../Styles/navbar.css"
import InfoIcon from '@mui/icons-material/Info';
import ContactSupportIcon from '@mui/icons-material/ContactSupport';
const NavBar = () => {
  let navi=useNavigate()
  let home=()=>{
    navi('/')
  }
  return (
    <div className='Navbar'>
        <div className="logo">
             <button onClick={home}>J Travels</button>
        </div>
        <div className="options">
        <Link to={'/about'}> <InfoIcon id="icon1"/> About us</Link>
        <Link to={'/contact'}><ContactSupportIcon id="icon2"/> Contact us</Link>
        <Link to={'/signin'}>Log In</Link>
        <Link to={'/adminlogin'}>Admin login</Link>
        </div>
    </div>
  )
}

export default NavBar