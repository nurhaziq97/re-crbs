import logo from './logo.svg';
import './App.css';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import NavbarHeader from "./components/Navbar.component";
import {useDispatch, useSelector} from "react-redux";
import {useCallback, useEffect, useState} from "react";
import {clearMessage} from "./actions/message";

const App = () => {
  const [showAdminBoard, setShowAdminBoard] = useState(false);
  const [showCarOwnerBoar, setShowCarOwnerBoard] = useState(false);
  const {user:currentUser} = useSelector((state) => state.auth);
  const dispatch = useDispatch();

  useEffect(() => {
      history.listen((location) => {
          dispatch(clearMessage());
      });
  }, [dispatch]);

  const logout = useCallback(()=>{
     dispatch(logout());
  },[dispatch])

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
