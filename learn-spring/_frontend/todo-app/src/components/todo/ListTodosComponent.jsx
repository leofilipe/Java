import { useEffect, useState } from 'react';
import { apiDeleteTodo, apiRetrieveAllTodosForUsername } from './api/TodoApiSercice';

export default function ListTodosComponent(){

    //not in use right now
    //const today = new Date();
    //const targetDate = new Date(today.getFullYear()+ 12, today.getMonth(), today.getDay());

    const[todos, setTodos] = useState([])

    const[message, setMessage] = useState(null)

    /*useEffect(() => {refreshTodos()}, []) 
    //In thesis, as there are no dependencies to load, we pass an empty list [] to the method
    //However, this does not work properly. From time to time the screen is not updated when an item is deleted
    //In fact, this raised the warning: react hook has a missing dependency 'refreshTodos'. Either include it or remove the dependency array
    
    useEffect(() => refreshTodos()) 
    //This show no warnings. However it also has inconsistent screen update
    
    useEffect(() => refreshTodos(), [refreshTodos])
    //This one works properly, but may trigger a rendering loop, as pointed by the warning it raises:
    //The ‘functionName’ function makes the dependencies of useEffect Hook (at line X) change on every render. 
    //Move it inside the useEffect callback. Alternatively, wrap the definition of ‘functionName’ 
    //in its own useCallback() Hook. 
    However, it triggers an infinite number of call to the function
    */

    //There are two solutions. 
    //1. Declare/implement refreshTodos inside useEffect. This works, but prevents external calls to refreshTodos
    //2. Wrap updateCount in a useCallback hook (not working)
   
    // const refreshTodos = useCallback(() => {
    //     apiRetrieveAllTodosForUsername('leo')
    //     .then(response => 
    //         {
    //             setTodos(response.data)
    //             //console.log(`todos atualizados ${todos}`)
    //         }
    //     )
    //     .catch(error => console.log(error))
    // }, [])
    
    //alternatively it seems to be working in response to changes in todo, leave like this for a while to check
    useEffect(() => {refreshTodos()}, [todos]) 
    
    function refreshTodos(){
        apiRetrieveAllTodosForUsername('leo')
        .then( response => 
            {
                setTodos(response.data)            }
        )
        .catch(error => console.log(error))
    }

    function deleteTodo(id){
        console.log('cliked '+ id)

        apiDeleteTodo('leo', id)
            .then(
                refreshTodos(),
                setMessage(`Success deleting of todo with id = ${id}!`)
                
            )
            .catch(error => console.log(error))
    }
    
    // const todos = [
    //     {id: 1, description: 'Learn AWS', done: false, targetDate: targetDate},
    //     {id: 2, description: 'Learn Full Stack Dev', done: false, targetDate: targetDate},
    //     {id: 3, description: 'Learn DevOps', done: false, targetDate: targetDate}
    // ]
    return(
        <div className='container'>
            <h1>Things You Want To Do!</h1>
            {message && <div className='alert alert-warning'>{message}</div>} {/* shows only if message is not null */}
            <div>
                <table className='table'>
                    <thead>
                        <tr>
                            {/* <td>Id</td> users are not concerned about todo's id */}
                            <th>Description</th>
                            <th>Is done?</th>
                            <th>Target date</th>
                            <th>Delete</th>
                        </tr>
                    </thead>
                    <tbody>
                        {todos.map(
                            todo =>(
                                <tr key = {todo.id}>
                                    {/* <td>{todo.id}</td> */}
                                    <td>{todo.description}</td>
                                    <td>{todo.done.toString()}</td>
                                    {/* <td>{todo.targetDate.toDateString()}</td> */}
                                    <td>{todo.targetDate.toString()}</td>
                                    <td>
                                        <button className='btn btn-danger'
                                            onClick={() => deleteTodo (todo.id)}>
                                            Delete</button>
                                    </td>
                                </tr>
                            )
                        )}
                        
                    </tbody>
                </table>
            </div>
        </div>
    )
}