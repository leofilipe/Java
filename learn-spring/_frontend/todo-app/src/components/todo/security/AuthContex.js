import { createContext, useContext, useState } from "react";

//create a context
export const AuthContext = createContext()

export const useAuth = () => useContext(AuthContext)


//share the context with other components
export default function AuthProvider({children}){ //"destructuring": 

    //Put context in the context
    const[isAuthenticated, setAuthenticated] = useState(false)

    const[username, setUsername] = useState('');

    //passes an object as an argument whilse using only its desired named properties.  
    //const sharedValue = {number, isAuthenticated, setAuthenticated}

    function logout(){

        setAuthenticated(false)
        setUsername('')
    }

    function login(username, password){

        if(username==='leo' && password==='dummy'){      
            setAuthenticated(true)
            setUsername(username)

            return true
        }else{
            setAuthenticated(false)
            setUsername('')

            return false
        }

    }

    return(
        <AuthContext.Provider value={{isAuthenticated, username, login, logout}}>
                                        {/*First pair of { } is JS way to embed vaulues.
                                        Second pair of { } is because number should be passed as an object*/}
            {children}
        </AuthContext.Provider>
    )
   
}