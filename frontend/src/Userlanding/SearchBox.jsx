import React, { useEffect, useState } from 'react'
import LocationOnIcon from '@mui/icons-material/LocationOn';
import PinDropIcon from '@mui/icons-material/PinDrop';
import axios from 'axios';
import SwapHorizIcon from '@mui/icons-material/SwapHoriz';
import "../Styles/landing.css"
const SearchBox = () => {
  let [from,setfrom]=useState("")
  let[to,setto]=useState("")
  let [show,setshow]=useState(false)
  let [buslist,setbuslist]=useState([])
  let sysdate=new Date()
  let dt=`${sysdate.getDate()}`
  let yr=`${sysdate.getFullYear()}`
  let mt=`${sysdate.getMonth()+1}`
  console.log(mt);
  let sysday=dt+"-"+mt+"-"+yr
  let [date,setdate]=useState(sysday)
  console.log(sysday);
  let search =(e)=>{
    e.preventDefault()
         axios.get(`http://localhost:8080/bus/route?from=${from}&to=${to}`)
         .then((response)=>{
          sessionStorage.setItem("BusList",JSON.stringify(response.data.data))
          setbuslist(response.data.data)
          console.log(date)
          console.log(response.data.data);
         })
         .catch((error)=>{
          console.log(error)
         })
  }
  useEffect(()=>{
    if(buslist!==0){
      setshow(true)
    }
  },[buslist])
  let swap=()=>{
        setfrom(to)
        setto(from)
  }
  return (
    <>
    <div id='searchbox'>
        <form action="">
            <div id='box' >
            <div id='input'><LocationOnIcon/><input type="text" value={from} onChange={(e)=>{setfrom(e.target.value)}}  placeholder='From' /></div>
            <div id="input"> <button id='cross' type='button' onClick={swap}><SwapHorizIcon/></button> </div>
           <div id='input'><PinDropIcon/><input type="text" value={to} onChange={(e)=>{setto(e.target.value)}} placeholder='To' /></div>
            <div id='input'> <input type="date"  value={date} onChange={(e)=>{setdate(e.target.value)}} required/>
            </div>
         
            <div id='input'>
              <button id='searchbutton' type="submit" onClick={search}>Search</button></div>
              </div>
            </form>
    </div>
      <div id='buscardplace'>
          { show &&  buslist.map((bus)=>{
      return(
        <>
           <button id='buscard'>
              <div id='buscontent'>
                    <img src={bus.imageurl} alt="bus iamge" />
                     <h2>{bus.name}</h2>
                  <div id='layer'>
                                 <div id="layer1">
                                    <h3>Dipature place : {bus.from}</h3>
                                    <h3> Dipatrue time : {bus.deptime}</h3>
                                        <h3>Reaching time : {bus.destime}</h3>
                                        <h3>Journey time : {bus.journey_hrs}</h3>
                                    
                               </div>
                               <div id="layer2">
                                        <h3>Destination place : {bus.to} </h3>
                                        <h3>Available seats : {bus.nos}</h3>
                                        <h3>{bus.category}</h3>
                                    <h3>Date : {date}</h3>
                               </div>
                  </div>
                   
              </div>
           </button>
        </>
      )
     })
          }
      </div>
    </>
  )
}

export default SearchBox