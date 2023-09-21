import React from 'react'
import LocationOnIcon from '@mui/icons-material/LocationOn';
import PinDropIcon from '@mui/icons-material/PinDrop';
const SearchBox = () => {
  return (
    <div id='searchbox'>
        <form action="">
            <div id='box' >
            <div id='input'>
           <LocationOnIcon/><input type="text"  placeholder='From' /></div>
           <PinDropIcon/> <div id='input'> <input type="text" placeholder='To' /></div>
            <div id='input'> <input type="date" /></div>
            <div id='input'><button id=''>Search</button></div>
            </div> 
            </form>

    </div>
  )
}

export default SearchBox