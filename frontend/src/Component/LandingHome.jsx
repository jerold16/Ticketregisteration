import React from 'react'
import SearchBox from '../Userlanding/SearchBox'
import "../Styles/landing.css"
import UserNav from '../Userlanding/UserNav'
const LandingHome = () => {
  return (
    <div className='landingUser'>
       <UserNav/>
          <div className=''>
             <SearchBox/>
          </div>
    </div>
  )
}

export default LandingHome