import React from 'react'
import Adminnav from './Adminnav'
import { Routes,Route } from 'react-router'
import Busregisteration from './Busregisteration'
const Adminlanding = () => {
  return (
    <div>
       <Adminnav/>
       <Routes>
              <Route path='/addbus' element={<Busregisteration/>}></Route>
       </Routes>
    </div>
  )
}

export default Adminlanding