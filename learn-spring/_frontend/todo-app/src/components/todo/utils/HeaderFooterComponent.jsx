import { Link } from "react-router-dom"

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

    return (
        <header className="border-bottom border-light border-5 mb-5 p-2">
            <div className="container">
                <div className="row">
                    <nav className="navbar navbar-expand-lg">
                        <a  className="navbar-brand ms-2 fs-2 fw-bold text-black"//should not use Link when leaving the SPA
                            href="https://github.com/leofilipe/Java/tree/learn-spring">LeoFilipe Java GitHub</a>
                        <div className="collapse navbar-collapse">
                            <ul className="navbar-nav">
                                <li className="nav-item fs-5">
                                    <Link  className="nav-link" to="/welcome/leo">Home</Link>
                                </li>
                                <li className="nav-item fs-5">
                                    <Link  className="nav-link" to="/todos/leo">Todos</Link>
                                </li>
                            </ul>
                        </div>
                        <ul className="navbar-nav">
                            <li className="nav-item fs-5">
                                <Link  className="nav-link" to="/logout">Logout</Link>
                            </li>
                            <li className="nav-item fs-5">
                                <Link  className="nav-link" to="/">Login</Link>
                            </li>
                        </ul>
                    </nav>
                </div>
            </div>
        </header>
    )
}