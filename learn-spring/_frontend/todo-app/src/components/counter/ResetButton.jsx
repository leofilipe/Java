export default function ResetButton({resetMethod}){

    function resetCounter(){
        resetMethod()

        console.log("Reseting...")
    }

    return (
        <div>
            <button className="resetButton" onClick={resetCounter}>Reset</button>
        </div>
    )
}