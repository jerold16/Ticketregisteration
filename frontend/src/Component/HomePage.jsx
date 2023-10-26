import React from 'react'
import "../Styles/homepage.css"
import NavBar from './NavBar'
import SearchBox from '../Userlanding/SearchBox'
import Dashboard from './Dashboard'
const HomePage = () => {
  return (
    <div className='Homepage'>
      <NavBar/>
      <SearchBox/>
      <Dashboard/>
    </div>
  )
}

export default HomePage