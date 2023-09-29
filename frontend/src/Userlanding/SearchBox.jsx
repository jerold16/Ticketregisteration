import React, { useState } from 'react'
import LocationOnIcon from '@mui/icons-material/LocationOn';
import PinDropIcon from '@mui/icons-material/PinDrop';
import axios from 'axios';
import "../Styles/landing.css"
const SearchBox = () => {
  let [from,setfrom]=useState("")
  let[to,setto]=useState("")
  let [date,setdate]=useState("")
  let search =(e)=>{
         e.preventDefault()
         axios.get(`http://localhost:8080/bus/route?from=${from}&to=${to}`)
         .then((response)=>{
          sessionStorage.setItem("BusList",JSON.stringify(response.data.data))
          console.log(date)
         })
         .catch((error)=>{
          console.log(error)
         })
  }
  return (
    <div id='searchbox'>
        <form action="">
            <div id='box' >
            <div id='input'><LocationOnIcon/><input type="text" value={from} onChange={(e)=>{setfrom(e.target.value)}}  placeholder='From' /></div>
           <div id='input'><PinDropIcon/><input type="text" value={to} onChange={(e)=>{setto(e.target.value)}} placeholder='To' /></div>
            <div id='input'> <input type="date" onChange={(e)=>{setdate(e.target.value)}}/></div>
            <div id='input'><button id='' onClick={search}>Search</button></div>
            </div> 
            </form>

    </div>
  )
}

export default SearchBox