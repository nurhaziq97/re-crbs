import logo from './logo.svg';
import './App.css';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import NavbarHeader from "./components/Navbar.component";

const App = () => {
  
  return(
    <div> 
      <BrowserRouter>
          <NavbarHeader />
        <Routes>
          {/* set the route path here */}
          <Route path="" element=""/>
        </Routes>
      </BrowserRouter>      
    </div>
  );
}

export default App;
