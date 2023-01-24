import React from 'react';
import { render, screen } from '@testing-library/react';
import App from './App';
import toJson from 'enzyme-to-json';
import{shallow,mount,configure} from 'enzyme';
import Adapter from 'enzyme-adapter-react-16';
import { Router } from 'react-router-dom';
import Signup from './users/Signup';
import Welcome from './Welcome';
import Login from './users/Login';
import WelcomeAdmin from './admin/WelcomeAdmin';

/*
test('renders learn react link', () => {
  render(<App />);
  const linkElement = screen.getByText(/learn react/i);
  expect(linkElement).toBeInTheDocument();
});
*/



configure({adapter:new Adapter()});
describe("rendering components",()=>{
  it("renders components without crash",()=>{
    shallow(<App/>)
  });
  it("renders signup page without crash",()=>{
    shallow(<Router>
      <Signup/>
    </Router>)
  });
  it("renders welcome page without crash",()=>{
    shallow(<Router>
      <Welcome/>
    </Router>)
  });
  it("renders Login page without crash",()=>{
    shallow(<Router>
      <Login/>
    </Router>)
  });
  it("renders Welcome admin page without crash",()=>{
    shallow(<Router>
      <WelcomeAdmin/>
    </Router>)
  });
  it("renders Welcome doctor page without crash",()=>{
    shallow(<Router>
      <WelcomeDoctor/>
    </Router>)
  });

})
