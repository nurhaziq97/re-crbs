import logo from './logo.svg';
import './App.css';
import { BrowserRouter } from 'react-router-dom';

const App = () => {
  
  return(
    <div> 
      <BrowserRouter>
        <Routes>
          {/* set the route path here */}
          <Route path="" element=""/>
        </Routes>
      </BrowserRouter>      
    </div>
  );
}

export default App;
