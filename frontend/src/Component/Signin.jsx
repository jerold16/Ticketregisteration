import React, { useState } from 'react'
import { Link, useNavigate } from 'react-router-dom'
import "../Styles/admin.css"
import axios from 'axios'
const Signin = () => {
  let [email,setemail]=useState("")
  let [password,setpassword]=useState("")
  let phone=0
  let navi=useNavigate()
  let login=(e)=>{
    e.preventDefault()
    if(email.includes("@")){
      axios.get(`http://localhost:8080/user/verifyemail?email=${email}&password=${password}`)
      .then((response)=>{
        localStorage.setItem("user",JSON.stringify(response.data.data))
        alert("login successful")
        navi("/landing")
      })
      .catch((error)=>{
        alert("something went wrong")
        console.log(error)
      })
    }
    else{
      phone=Number(email)
      axios.get(`http://localhost:8080/user/verifyphone?phone=${phone}&password=${password}`)
      .then((response)=>{
        localStorage.setItem("user",JSON.stringify(response.data.data))
        alert("login successful")
        navi("/landing")
      })
      .catch((error)=>{
        alert("something went wrong")
        console.log(error)
      })
    }
  }
  return (
    <div id='Usersignin'>

            <form id='form' action="">
                <h1>User Login </h1>
                <input type="text" onChange={(e)=>{setemail(e.target.value)}} placeholder='Enter the email or phone number' />
                <input type="password" onChange={(e)=>{setpassword(e.target.value)}} placeholder='Enter the password' />
                <button onClick={login}>Sign in</button>
            <Link to={'/register'}>Click here to create Account...</Link>
            </form>
        
    </div>
  )
}

export default Signin