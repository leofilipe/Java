import { Link } from "react-router-dom"
import { useAuth } from "../security/AuthContex"

export function FooterComponent(){
    return(
        <footer className="footer">
            <div className="container">
                &copy; 2024.    
            </div>
             

        </footer>
    )
}

export default function HeaderComponent(){

    const authContext = useAuth()
    const isAuthenticated = authContext.isAuthenticated
    const username = authContext.username

    return (
        <header className="border-bottom border-light border-5 mb-5 p-2">
            <div className="container">
                <div className="row">
                    <nav className="navbar navbar-expand-lg">
                        <a  className="navbar-brand ms-2 fs-2 fw-bold text-black"//should not use Link when leaving the SPA
                            href="https://github.com/leofilipe/Java/tree/learn-spring">LeoFilipe Java GitHub</a>
                        <div className="collapse navbar-collapse">
                            <ul className="navbar-nav">
                                {
                                isAuthenticated && 
                                    <>
                                        <li className="nav-item fs-5">
                                            <Link  className="nav-link" to={`/welcome/${username}`}>Home</Link>
                                        </li>
                                        <li className="nav-item fs-5">
                                            <Link  className="nav-link" to={`/todos/${username}`}>Todos</Link>
                                        </li>
                                    </>
                                }
                                
                            </ul>
                        </div>
                        <ul className="navbar-nav">
                            {!isAuthenticated &&
                                <li className="nav-item fs-5">
                                    <Link  className="nav-link" to="/">Login</Link>
                                </li>
                            }
                            {isAuthenticated &&
                                <li className="nav-item fs-5">
                                    <Link  className="nav-link" to="/logout">Logout</Link>
                                </li>
                            }
                        </ul>
                    </nav>
                </div>
            </div>
        </header>
    )
}