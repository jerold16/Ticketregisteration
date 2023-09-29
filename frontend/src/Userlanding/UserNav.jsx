import React from 'react'
import { useNavigate } from 'react-router'
import "../Styles/navbar.css"
import InfoIcon from '@mui/icons-material/Info';
import ContactSupportIcon from '@mui/icons-material/ContactSupport';
import { Link } from 'react-router-dom';
const UserNav = () => {
    let navi=useNavigate()
  let home=()=>{
    navi('/')
  }
  let logout=()=>{
    sessionStorage.removeItem("user")
  }
  return (
    <div className='Navbar'>
        <div className="logo">
             <button onClick={home}>J Travels</button>
        </div>
        <div className="options">
        <Link to={'/about'}> <InfoIcon id="icon1"/> About us</Link>
        <Link to={'/contact'}><ContactSupportIcon id="icon2"/> Contact us</Link>
        <Link onClick={logout} to={'/'}>Log Out</Link>
        </div>
    </div>
  )
}

export default UserNav