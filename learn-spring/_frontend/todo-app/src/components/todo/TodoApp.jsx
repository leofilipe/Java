import "../css/Todo.css";

import { BrowserRouter, Route, Routes } from "react-router-dom";

import AuthProvider from "./security/AuthContex";

import LoginComponent, { LogoutComponent } from "../login/LoginComponent";
import WelcomeComponent from "./utils/WelcomeComponent";
import ErrorComponent from "./utils/ErrorComponent";
import ListTodosComponent from "./ListTodosComponent";
import HeaderComponent, { FooterComponent } from "./utils/HeaderFooterComponent";

export default function TodoApp(){
    return (
        <div className="TodoApp">

            <AuthProvider>
                <BrowserRouter>
                    <HeaderComponent/>
                    <Routes>
                        <Route path="/" element={<LoginComponent/>}/>
                        <Route path="/login" element={<LoginComponent/>}/>
                        <Route path="/welcome/:username" element={<WelcomeComponent/>}/>
                        <Route path="/todos/:username" element={<ListTodosComponent/>}/>
                        
                        <Route path="/logout" element={<LogoutComponent/>}/>

                        <Route path="*" element={<ErrorComponent/>}/>
                    </Routes>
                    <FooterComponent/>
                </BrowserRouter>
            </AuthProvider>
        </div>
    )
}
