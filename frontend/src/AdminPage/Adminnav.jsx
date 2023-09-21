import React from 'react'
import { Link } from 'react-router-dom'
import "../Styles/admin.css"
const Adminnav = () => {
  return (
    <div id='Adminnav'>
           <Link to="/adminland/addbus">Add the Bus</Link>
    </div>
  )
}

export default Adminnav