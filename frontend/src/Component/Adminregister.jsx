import axios from 'axios'
import React, { useState } from 'react'
import { useNavigate } from 'react-router'
const Adminregister = () => {
  let [name,setname]=useState("")
  let [email,setemail]=useState("")
  let [phone,setphone]=useState("")
  let [password,setpassword]=useState("")
  let [gst,setgst]=useState("")
  let navi=useNavigate()
  let admin={name,email,password,phone,gst}
  let register=(e)=>{
          e.preventDefault()
          axios.post(`http://localhost:8080/admin`,admin)
          .then((response)=>{
            alert("Submitted successfully")
            navi("/adminlogin")
          })
  }
  return (
    <div id='adregister'>
      <form id='form2' action="">
                <h1>Admin Registeration </h1>
                <input type="name" value={name} onChange={(e)=>{setname(e.target.value)}} placeholder='Enter the Name' />
                <input type="email" value={email} onChange={(e)=>{setemail(e.target.value)}} placeholder='Enter the Email' />
                <input type="tel" pattern='[0-9]{10}' value={phone} onChange={(e)=>{setphone(e.target.value)}} placeholder='Enter the Phone' />
                <input type="text" value={password} onChange={(e)=>{setpassword(e.target.value)}} placeholder='Enter the Password' />
                <input type="text" value={gst} onChange={(e)=>{setgst(e.target.value)}} placeholder='Enter the Gst number' />
                <button onClick={register}>Register</button>
            </form>
        
    </div>
  )
}

export default Adminregister
