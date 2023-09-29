import React, { useState } from 'react'
import { Link, useNavigate } from 'react-router-dom'
import "../Styles/admin.css"
import axios from 'axios'

import { ToastContainer, toast } from 'react-toastify';
  import 'react-toastify/dist/ReactToastify.css';
const AdminLogin = () => {
  let [email,setemail]=useState("")
  let [password,setpassword]=useState("")
  let phone=0
  let navi=useNavigate()
  let login=(e)=>{
    e.preventDefault()
    if(email.includes("@")){
      axios.get(`http://localhost:8080/admin/verifyemail?email=${email}&password=${password}`)
      .then((response)=>{
        toast.success("Admin login Successfull")
        sessionStorage.setItem("admin",JSON.stringify(response.data.data))
        
        navi("/adminland")
      })
      .catch((error)=>{
      toast.error("Something Went Wrong...")
        console.log(error)
      })
    }
    else{
      phone=Number(email)
      axios.get(`http://localhost:8080/admin/verifyphone?phone=${phone}&password=${password}`)
      .then((response)=>{
        toast.success("Admin login Successfull")
        sessionStorage.setItem("admin",JSON.stringify(response.data.data))
        
        navi("/adminland")
      })
      .catch((error)=>{
        toast.error("Something Went Wrong...")
        console.log(error)
      })
    }
  }
  return (
    <div id="adminlogin">
         
            <form id='form' action="">
                <h1>Admin Login </h1>
                <input type="email" onChange={(e)=>{setemail(e.target.value)}} placeholder='Enter the email or phone number' />
                <input type="password" onChange={(e)=>{setpassword(e.target.value)}} placeholder='Enter the password' />
                <button onClick={login}>Sign in</button>
            <Link to={'/adminregis'}>Click here to create Account...</Link>
            <ToastContainer/> </form>
        
    </div>
  )
}

export default AdminLogin