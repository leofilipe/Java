import { Link, useParams } from "react-router-dom"

export default function WelcomeComponent(){

    const {username} = useParams();
    //console.log(username);
    //const url = `/todos/${username}`;

    return(
        <div className="Welcome">
            <div><h1>Welcome {username}</h1></div>
            <div><h3><Link to={`/todos/${username}`}>Manage are your todos</Link></h3></div>
        </div>
    )
}