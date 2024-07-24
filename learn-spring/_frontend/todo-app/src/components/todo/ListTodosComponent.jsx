import { useEffect, useState } from "react";
import { retrieveAllTodosForUsername } from "./api/TodoApiSercice";

export default function ListTodosComponent(){

    const today = new Date();
    const targetDate = new Date(today.getFullYear()+ 12, today.getMonth(), today.getDay());

    const[todos, setTodos] = useState([])

    useEffect(() => refreshTodos(), [])    //as there are no dependencies to load
                                            // we pass an empty list [] to the method
    

    function refreshTodos(){
        retrieveAllTodosForUsername('leo')
        .then( response => 
            {
                //console.log(response)
                setTodos(response.data)
            }
        )
        .catch(error => console.log(error))
    }
    
    // const todos = [
    //     {id: 1, description: "Learn AWS", done: false, targetDate: targetDate},
    //     {id: 2, description: "Learn Full Stack Dev", done: false, targetDate: targetDate},
    //     {id: 3, description: "Learn DevOps", done: false, targetDate: targetDate}
    // ]
    return(
        <div className="container">
            <h1>Things You Want To Do!</h1>
            <div>
                <table className="table">
                    <thead>
                        <tr>
                            <td>Id</td>
                            <td>Description</td>
                            <td>Is done?</td>
                            <td>Target date</td>
                        </tr>
                    </thead>
                    <tbody>
                        {todos.map(
                            todo =>(
                                <tr key = {todo.id}>
                                    <td>{todo.id}</td>
                                    <td>{todo.description}</td>
                                    <td>{todo.done.toString()}</td>
                                    {/* <td>{todo.targetDate.toDateString()}</td> */}
                                    <td>{todo.targetDate.toString()}</td>
                                </tr>
                            )
                        )}
                        
                    </tbody>
                </table>
            </div>
        </div>
    )
}