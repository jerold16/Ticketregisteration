import React from 'react'
import { BrowserRouter, Route, Routes } from 'react-router-dom'
import Signin from './Component/Signin'
import "./index.css"
import HomePage from './Component/HomePage'
import Contactus from './Component/Contactus'
import About from './Component/About'
import Adminregister from './Component/Adminregister'
import UserRegister from './Component/UserRegister'
import LandingHome from './Component/LandingHome'
import Adminlanding from './AdminPage/Adminlanding'
import Error from './Component/Error'
import Protect from './Component/Protect'
import AdminLogin from './Component/AdminLogin'
const App = () => {
  return (
    <div>
      <BrowserRouter>
        <Routes>
          <Route path='/' element={<HomePage/>}/>
            <Route path='/signin' element={<Signin/>}/>
            <Route path='/register' element={<UserRegister/>}/>
            <Route path='/contact' element={<Contactus/>}/>
            <Route path='/adminlogin' element={<AdminLogin/>} />
            <Route path='/about' element={<About/>} ></Route>
            <Route path='/adminregis' element={<Adminregister/>} />
            <Route path='/landing' element={<Protect Child={LandingHome}/>}/>
            <Route path='/adminland/*' element={<Protect Child={Adminlanding}/>}/>
            <Route path='/*' element={<Error/>}/>
        </Routes>
        </BrowserRouter>
        
    </div>
  )
}

export default App