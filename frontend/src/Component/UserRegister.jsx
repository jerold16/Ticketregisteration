import React, { useState } from 'react'
import "../Styles/admin.css"
import axios from 'axios'
import { useNavigate } from 'react-router'
import NavBar from './NavBar'
const UserRegister = () => {
  let navi=useNavigate()
    let [name,setname]=useState("")
    let [email,setemail]=useState("")
    let [phone,setphone]=useState("")
    let [dob,setdob]=useState("")
    let [password,setpassword]=useState("")
    let [aadharnum,setaadhar]=useState("")
    let user={name,email,phone,dob,password,aadharnum}
    let register =(e)=>{
      e.preventDefault()
      axios.post((`http://localhost:8080/user`),user)
      .then((response)=>{
        alert("Submitted succesfully")
        navi("/signin")
      })
      .catch((error)=>{
        alert("something went wrong")
        console.log(error)
      })
    }
    return (
      <div>
        <NavBar/>
        <div id='userregister'>
        <form id='form2' action="">
                  <h1>User Registeration </h1>
                  <input type="name" value={name} onChange={(e)=>{setname(e.target.value)}} placeholder='Enter the Name' />
                  <input type="email" value={email} onChange={(e)=>{setemail(e.target.value)}} placeholder='Enter the Email' />
                  <input type="tel" pattern='[0-9]{10}' value={phone} onChange={(e)=>{setphone(e.target.value)}} placeholder='Enter the Phone' />
                  <input type="text" value={password} onChange={(e)=>{setpassword(e.target.value)}} placeholder='Enter the Password' />
                  <input type="date" value={dob} onChange={(e)=>{setdob(e.target.value)}}/>
                  <input type="tel" pattern='[0-9]{12}' value={aadharnum} onChange={(e)=>{setaadhar(e.target.value)}} placeholder='Enter the Aadhar number' />
                  <button onClick={register}>Register</button>
              </form>
          
      </div>
      </div>
    )
}

export default UserRegister