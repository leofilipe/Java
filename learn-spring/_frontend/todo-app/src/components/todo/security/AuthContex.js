import { createContext, useContext, useState } from "react";

//create a context
export const AuthContext = createContext()

export const useAuth = () => useContext(AuthContext)


//share the context with other components
export default function AuthProvider({children}){ //"destructuring": 

    //Put context in the context
    const[number, setNumber] = useState(0)

    const[isAuthenticated, setAuthenticated] = useState(false)

    const[username, setUsername] = useState('');

    setInterval(()=>setNumber(number + 1), 10000) //updates the state every 10s

    //passes an object as an argument whilse using only its desired named properties.
    
    //const sharedValue = {number, isAuthenticated, setAuthenticated}
    return(
        <AuthContext.Provider value={{number, isAuthenticated, setAuthenticated, username, setUsername}}>{/*First pair of { } is JS way to embed vaulues.
                                                Second pair of { } is because number should be passed as an object*/}
            {children}
        </AuthContext.Provider>
    )
   
}