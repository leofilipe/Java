import { useState } from "react"
import { Link, useParams } from "react-router-dom"
import { retrieveHelloWorldBean, retrieveHelloWorldPathVariable } from "../api/HelloWorldApiService"

export default function WelcomeComponent(){

    const {username} = useParams()

    const[message, setMessage] = useState(null)

    function callHelloWorldRestApiPath(username){

        console.log("hello world Path works!")
        retrieveHelloWorldPathVariable("leo")//retrieveHelloWorldPathVariable(username)
        // axios.get("http://localhost:8080/hello-world")
            .then((response) => successfullResponse(response))
            .catch((error) => errorResponse(error))
            .finally(() => console.log('cleanup'))
    }

    function callHelloWorldBeanRestApi(){
        console.log("hello world Api works!")
        retrieveHelloWorldBean()
        // axios.get("http://localhost:8080/hello-world")
            .then((response) => successfullResponse(response))
            .catch((error) => errorResponse(error))
            .finally(() => console.log("clean up bean"))
    }

    function successfullResponse(response){
        console.log(response)

        if (typeof response.data == 'string') {
            setMessage(response.data) //you can check console to find the field name used by response for the data
        }else{
            setMessage(response.data.message)
        }

        //
    }

    function errorResponse(error){
        console.log(error)
    }

    return(
        <div className="container">
            <div><h1>Welcome {username}</h1></div>
            <div><h3><Link to={`/todos/${username}`}>Manage are your todos</Link></h3></div>
            <div>
                <button className="btn btn-success" onClick={callHelloWorldBeanRestApi}>
                    Call Hello Bean
                </button>
            </div>
            <div>
                <button className="btn btn-success" onClick={callHelloWorldRestApiPath}>
                    Call Hello Bean Path
                </button>
            </div>
            <div className="text-info">{message}</div>
        </div>
    )
}