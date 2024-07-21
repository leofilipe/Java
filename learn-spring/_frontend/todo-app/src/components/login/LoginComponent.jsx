import { useState } from "react"

export default function LoginComponent(){

    const[username, setUsername] = useState('leo');
    const[password, setPassword] = useState('');

    const[authenticated, setAuthenticated] = useState(false);
    const[authenticationError, setAuthenticationError] = useState(false);

    function handleUsernameChange(event){

        let newValue = event.target.value;

        console.log(newValue)
        setUsername(newValue)
    }

    function handlePasswordChange(event){
        let newValue = event.target.value;
        console.log(newValue)
        setPassword(newValue)

    }

    function handleSumbit(){
        
        if(username==='leo' && password==='dummy'){      
            setAuthenticated(true)
            setAuthenticationError(false)
        }else{
            setAuthenticated(false)
            setAuthenticationError(true)
        }

        console.log(authenticated)
    }

    // function SuccessMessageComponent(){
    //     if(authenticated)
    //         return(
    //             <div className="authenticated">Authenticated Successfully!</div>
    //         )
    //     else
    //         return null;
    // }

    // function FailMessageComponent(){
    //     if(authenticationError)
    //         return(
    //             <div className="authenticationError">Authenticated Failed! Please check your credentials...</div>
    //         )
    //     else
    //         return null
    // }
    return(
        <div className="Login">
            {/* <div className="successMessage" hidden={!authenticated}>Authenticated Successfully</div>
            <div className="errorMessabe" hidden={!authenticationError}>Authenticated failed. Please check your credentials</div> */}
            
            {/* <SuccessMessageComponent/>
            <FailMessageComponent/> */}

            {authenticated && <div className="successMessage">Authenticated Successfully</div>}
            {authenticationError && <div className="errorMessabe">Authenticated failed. Please check your credentials</div>}
            <div className="LoginForm">
                <div>
                    <label>User name: </label>
                    <input type="text" name="username" value={username} onChange={handleUsernameChange}/>
                </div>
                <div>
                    <label>Password: </label>
                    <input type="password" name="password" value={password} onChange={handlePasswordChange}/>
                </div>
                <div>
                    <button type="button" name="login" onClick={handleSumbit}>Login</button>
                </div>
            </div>
        </div>
    )
}