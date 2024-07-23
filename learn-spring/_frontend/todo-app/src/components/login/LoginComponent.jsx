import { useNavigate } from "react-router-dom";
import { useState } from "react"
import { useAuth } from "../todo/security/AuthContex";

export function LogoutComponent(){
    
    const authContext = useAuth();

    authContext.logout()

    //does not even happen anymore. Once remove the authorization (above), 
    //ur promptly redirected to login
    return (
        <div className="container">
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

    const[authenticationError, setAuthenticationError] = useState(false);

    const authContext = useAuth();

    function handleUsernameChange(event){

        let newValue = event.target.value;
        setUsername(newValue)

    }

    function handlePasswordChange(event){
        let newValue = event.target.value;
        setPassword(newValue)
    }

    function handleSumbit(){
        
        if(authContext.login(username, password)){      
            setAuthenticationError(false)
            navigate(`/welcome/${username}`)//use ticks (crases)
        }else{
            setAuthenticationError(true)
        }
    }

    return(
        <div className="container">

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