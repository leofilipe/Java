import './App.css';
import Counter from './components/counter/Counter';
//import LearningComponent from './components/learning-examples/LearningComponent';
//import { Component } from 'react';


//import {FirstComponent, SecondComponent, ThirdComponent, FourthComponent} from './components/learning-examples/'

function App() {
  return (
    <div className="App">
      {/*<PlayWithProps property1="value1" property2="value2"/>*/}
 
      {/* <CounterButton by={1}/>
      <CounterButton by={2}/>
      <CounterButton by={5}/> 
    
      <CounterButton/> */}
      <Counter/>
    </div>
  );
}

//modern use of properties
function PlayWithProps({property1, property2}){

  console.log(property1)
  console.log(property2)

  return(
    <div>Props</div>
  )
}

// classic use of properties
// function PlayWithProps(properties){
//   console.log(properties)
//   console.log(properties.property1)
//   console.log(properties.property2)

//   //console.log(properties)
//   return(
//     <div>Props</div>
//   )
// }







export default App;
