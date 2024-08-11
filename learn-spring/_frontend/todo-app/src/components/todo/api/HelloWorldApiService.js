import axios from "axios";

const apiClient = axios.create(
    {
        baseURL:'http://localhost:8080'
    }
)
// export function retrieveHelloWorldBean(){

//     return axios.get("http://localhost:8080/hello-world")   
// }

//same as above
export const retrieveHelloWorldBean =  () => apiClient.get("/hello-world-bean",
    {
        headers: {
            Authorization: 'Basic bGVvOmR1bW15' //also, we also shouldnt hardcode the autorization header

        }
    }  
)

export const executeBasicAuthenticationService =  (token) => apiClient.get('/basicauth',
    {
        headers: {
            Authorization: token //also, we also shouldnt hardcode the autorization header

        }
    }  
)

export const retrieveHelloWorldPathVariable = (username) => apiClient.get(`/hello-world/path-variable/${username}`,
    //no headers results in error: has been blocked by CORS policy
    //headers with encoded user and passwords results in error: 
    //  has been blocked by CORS policy: Response to preflight request
    //  doesn't pass access control check: No 'Access-Control-Allow-Origin' 
    //  header is present on the requested resource.

    // preflight request is an OPTIONS request, a pre-request before actual request that 
    //  should be enabled first.

    {
        headers: {
            Authorization: 'Basic bGVvOmR1bW15' //also, we also shouldnt hardcode the autorization header

        }
    
    })