import axios from "axios";

const apiClient = axios.create({
    baseURL: 'http://localhost:8080'
    
})

export const apiRetrieveAllTodosForUsername = 
    (username) => apiClient.get(`/users/${username}/todos`)

export const apiRetriveTodoForUsername = 
    (username, id) => apiClient.get(`/users/${username}/todos/${id}`)

export const apiDeleteTodo = 
    (username, id) => apiClient.delete(`/users/${username}/todos/${id}`)

export const apiUpdateTodo =
    (username, id, todo) => apiClient.put(`/users/${username}/todos/${id}`, todo /*returned as the body of the request*/)

export const apiCreateTodo =
    (username, todo) => apiClient.post(`/users/${username}/todos`, todo /*returned as the body of the request*/)
