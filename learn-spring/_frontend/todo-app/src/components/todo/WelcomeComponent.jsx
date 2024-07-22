import { useParams } from "react-router-dom"

export default function WelcomeComponent(){

    const {username} = useParams();
    console.log(username);

    return(
        <div className="Welcome">Welcome {username}</div>
    )
}