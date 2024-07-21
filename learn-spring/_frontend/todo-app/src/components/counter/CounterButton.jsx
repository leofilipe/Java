import { PropTypes} from 'prop-types'
import './Counter.css'


export default function CounterButton
        ({by = 1, incrementMethod} /*{by} see comment at the end*/){
    
    console.log(by)

    // function incrementCounterFunction(){

    //     incrementMethod(by)
    // }

    // function decrementCounterFunction(){
        
    //     incrementMethod(-by)
    // }

    return (
        <div className="Counter">
            <div>
                <span>
                    <button className="counterButton" 
                        onClick={() => incrementMethod(by)}
                        // onClick={incrementCounterFunction}
                        >+{by}</button>
                </span>
                <span>
                    <button className='counterButton'
                        // onClick={decrementCounterFunction}
                        onClick={() => incrementMethod(-by)}
                        >-{by}</button>
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