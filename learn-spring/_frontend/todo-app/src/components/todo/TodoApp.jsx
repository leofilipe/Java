import "../css/Todo.css";

import { BrowserRouter, Navigate, Route, Routes } from "react-router-dom";

import AuthProvider, { useAuth } from "./security/AuthContex";

import LoginComponent, { LogoutComponent } from "../login/LoginComponent";
import WelcomeComponent from "./utils/WelcomeComponent";
import ErrorComponent from "./utils/ErrorComponent";
import ListTodosComponent from "./ListTodosComponent";
import HeaderComponent, { FooterComponent } from "./utils/HeaderFooterComponent";

function AuthenticatedRoute({children}){
    
    const authContext = useAuth()

    if(authContext.isAuthenticated)
        return children
    else
        return <Navigate to="/login"/>
    
}

export default function TodoApp(){
    return (
        <div className="TodoApp">

            <AuthProvider>
                <BrowserRouter>
                    <HeaderComponent/>
                    <Routes>
                        <Route path="/" element={<LoginComponent/>}/>
                        <Route path="/login" element={<LoginComponent/>}/>
                        
                        <Route path="/welcome/:username" element={
                            <AuthenticatedRoute>
                                <WelcomeComponent/>
                            </AuthenticatedRoute>
                        }/>
                        <Route path="/todos/:username" element={
                            <AuthenticatedRoute>
                                <ListTodosComponent/>
                            </AuthenticatedRoute>
                        }/>
                        
                        <Route path="/logout" element={
                            <AuthenticatedRoute>
                                <LogoutComponent/>
                            </AuthenticatedRoute>
                        }/>

                        <Route path="*" element={<ErrorComponent/>}/>
                    </Routes>
                    <FooterComponent/>
                </BrowserRouter>
            </AuthProvider>
        </div>
    )
}
