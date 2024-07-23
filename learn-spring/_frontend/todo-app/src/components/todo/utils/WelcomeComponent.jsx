import { Link, useParams } from "react-router-dom"

export default function WelcomeComponent(){

    const {username} = useParams();

    return(
        <div className="container">
            <div><h1>Welcome {username}</h1></div>
            <div><h3><Link to={`/todos/${username}`}>Manage are your todos</Link></h3></div>
        </div>
    )
}