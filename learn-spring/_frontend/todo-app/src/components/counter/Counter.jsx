
import { useState } from "react";
import CounterButton from "./CounterButton";

import './Counter.css'
import ResetButton from "./ResetButton";

export default function Counter(){

    //state is  an array so that [value, function]
    //const state = useState(0);
    //hence, to simplify its use better use an approach such as
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