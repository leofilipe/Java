import { redirect, useNavigate } from "react-router-dom";
import { useState } from "react"
import { useAuth } from "../todo/security/AuthContex";

export function LogoutComponent(){
    
    const authContext = useAuth();

    authContext.setAuthenticated(false)
    authContext.setUsername('');

    //redirect("/")

    //setInterval(()=> redirect("/"), 5000) //updates the state every 5s

    return (
        <div className="Logout">
            <h1>You have logged out!</h1>
            <div>Please come back soon!</div>
            <div>Redirecting to Login in 5s</div>
        </div>
    )
}

export default function LoginComponent(){

    const navigate = useNavigate();

    const[username, setUsername] = useState('leo');
    const[password, setPassword] = useState('');

    //const[authenticated, setAuthenticated] = useState(false);
    const[authenticationError, setAuthenticationError] = useState(false);

    const authContext = useAuth();
    

    //console.log(authContext);

    function handleUsernameChange(event){

        let newValue = event.target.value;

        //console.log(newValue)
        setUsername(newValue)
    }

    function handlePasswordChange(event){
        let newValue = event.target.value;
        //console.log(newValue)
        setPassword(newValue)

    }

    function handleSumbit(){
        
        if(username==='leo' && password==='dummy'){      
            //setAuthenticated(true)
            setAuthenticationError(false)

            authContext.setAuthenticated(true)
            authContext.setUsername(username)

            //console.log(`success!! ${authContext.isAuthenticated} logged in!`)
            navigate(`/welcome/${username}`)//use ticks (crases)
        }else{
            //setAuthenticated(false)
            setAuthenticationError(true)
            authContext.setAuthenticated(false)
            authContext.setUsername('')
        }

        //console.log(authContext.authenticated)
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

            {authContext.authenticated && <div className="successMessage">Authenticated Successfully</div>}
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