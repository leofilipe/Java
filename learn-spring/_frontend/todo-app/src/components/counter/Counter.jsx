
import { useState } from "react";
import CounterButton from "./CounterButton";

import './Counter.css'
import ResetButton from "./ResetButton";

export default function Counter(){

    const [count, setCount] = useState(0);

    function incrementTotalCounter(by){
        setCount(count + by)
    }

    function resetTotalCounter(){
        setCount(0)
    }

    return(
        <div>
            <span className="totalCount">{count}</span>
            <CounterButton incrementMethod={incrementTotalCounter}/>
            <CounterButton by={2} incrementMethod={incrementTotalCounter}/>
            <CounterButton by={5} incrementMethod={incrementTotalCounter}/>
            <ResetButton resetMethod={resetTotalCounter}/>
        </div>
    )
}

// function CounterButton({by = 1, incrementMethod}){
//     const [count, setCount] = useState(0);
    
//     console.log(by)

//     function incrementCounterFunction(){

//         setCount(count+by)

//         incrementMethod(by)

//         console.log(count)
//     }

//     function decrementCounterFunction(){
//         setCount(count-by)
        
//         incrementMethod(-by)

//         console.log(count)
//     }

//     return (
//         <div className="Counter">
//             <span className="count">{count}</span>
//             <div>
//                 <span>
//                     <button className="counterButton" 
//                         onClick={incrementCounterFunction}
//                         >+{by}</button>
//                 </span>
//                 <span>
//                     <button className='counterButton'
//                         onClick={decrementCounterFunction}>-{by}</button>
//                 </span>
//             </div>
//         </div>
//     )
// }

// CounterButton.propTypes = {

//     by: PropTypes.number
// }
