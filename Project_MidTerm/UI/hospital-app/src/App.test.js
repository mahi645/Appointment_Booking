import React from 'react';
import { render, screen } from '@testing-library/react';
import App from './App';
import toJson from 'enzyme-to-json';
import{shallow,mount,configure} from 'enzyme';
import Adapter from 'enzyme-adapter-react-16';

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
})
