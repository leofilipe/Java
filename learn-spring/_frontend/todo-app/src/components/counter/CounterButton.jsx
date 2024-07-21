import { useState } from 'react'
import { PropTypes} from 'prop-types'

import './Counter.css'


export default function CounterButton({by = 1, incrementMethod}
    /*{by} see comment at the end*/){

    //state is  an array so that [value, function]
    //const state = useState(0);
    //hence, to simplify its use better use an approach such as
    const [count, setCount] = useState(0);
    
    console.log(by)

    function incrementCounterFunction(){

        setCount(count+by)

        incrementMethod(by)

        console.log(count)
    }

    function decrementCounterFunction(){
        setCount(count-by)
        
        incrementMethod(-by)

        console.log(count)
    }

    return (
        <div className="Counter">
            <div>
                <span>
                    <button className="counterButton" 
                        onClick={incrementCounterFunction}
                        >+{by}</button>
                </span>
                <span>
                    <button className='counterButton'
                        onClick={decrementCounterFunction}>-{by}</button>
                </span>
            </div>
        </div>
    )
}

CounterButton.propTypes = {

    by: PropTypes.number
}

// Support for defaultProps will be removed from function components in a future 
// major release. Use JavaScript default parameters instead.
// Counter.defaultProps = {
//     by: 1
// }