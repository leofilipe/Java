import { createContext, useState } from "react";

//create a context
export const AuthContext = createContext()


//share the context with other components
export default function AuthProvider({children}){ //"destructuring": 

    //Put context in the context
    const[number, setNumber] = useState(0)

    //passes an object as an argument whilse using only its desired named properties.
    
    return(
        <AuthContext.Provider value={{number}}>{/*First pair of { } is JS way to embed vaulues.
                                                Second pair of { } is because number should be passed as an object*/}
            {children}
        </AuthContext.Provider>
    )
   
}