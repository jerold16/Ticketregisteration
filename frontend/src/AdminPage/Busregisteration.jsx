import axios from 'axios'
import React, { useState } from 'react'
import "../Styles/admin.css"
import { useNavigate } from 'react-router'
const Busregisteration = () => {
    let admin=JSON.parse(sessionStorage.getItem("admin"))
    let id=admin.id
    let [name,setName]=useState("")
    let [busnum,setNumber]=useState("")
    let [from,setdeparture]=useState("")
    let [to,setdestination]=useState("")
    let [dor,setdor]=useState("")
    let [nos,setnos]=useState("")
    let data={name,busnum,from,to,dor,nos}
    let navi=useNavigate()
let register=(e)=>{
      e.preventDefault()
      axios.post(`http://localhost:8080/bus/${id}`,data)
      .then((response)=>{
        alert("bus has been added")
        navi("/adminland")
      })
      .catch((error)=>{
        alert("something went wrong")
        console.log(error)
      })
}
let cancel=()=>{
  navi("/adminland")
}
  return (
    <div id='busregisteration'>
        <form id='form2' action="">
          <h2>Bus Registeration</h2>
         <div id='input'>
         <div>
          <input type="text" value={name} onChange={(e)=>{setName(e.target.value)}} placeholder='Enter the Name'/>
             <input type="text" value={busnum} placeholder='Enter the Busnumber' onChange={(e)=>{setNumber(e.target.value)}}/>
         <input type="text" value={from} placeholder='Enter the Departure' onChange={(e)=>{setdeparture(e.target.value)}}/>
        <input type="text"value={to} placeholder='Enter the Destination' onChange={(e)=>{setdestination(e.target.value)}} />
          <input type="date"value={dor} placeholder='Enter the Dateo of registeration' onChange={(e)=>{setdor(e.target.value)}} />
          
          </div>
       <div> <input type="text" value={nos} placeholder='Enter the Number of seats' onChange={(e)=>{setnos(e.target.value)}}/>
          <input type="text" placeholder='Departure time 00:00'/>
          <input type="text" placeholder='Destination time 00:00'/>
          <input type="text" placeholder='Enter image url' />
          <input type="text" placeholder='Sleeper or non sleeper' />
          </div>
         </div>
           <div id='buttonsection'>  
           <button id='button' onClick={cancel}>cancel</button>
           <button id='button' onClick={register}>Register</button>
           </div>
        </form>
    </div>
  )
}

export default Busregisteration