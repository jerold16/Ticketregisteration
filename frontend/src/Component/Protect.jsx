import React from 'react'
import HomePage from './HomePage';

const Protect = ({Child}) => {
    let admin =JSON.parse(sessionStorage.getItem("admin"))
    let user =JSON.parse(sessionStorage.getItem("user"))
    let verify=()=>{
        if(admin==null && user==null)
           return false;
        else
           return true;
    }
  return (
    <div>
              {
                verify() ? <Child/> : <HomePage/>
              }
    </div>
  )
}

export default Protect