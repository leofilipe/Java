import { useNavigate, useParams } from "react-router-dom"
import { useAuth } from "./security/AuthContex"
import { apiCreateTodo, apiRetriveTodoForUsername, apiUpdateTodo } from "./api/TodoApiService";
import { useCallback, useEffect, useState } from "react";
import { ErrorMessage, Field, Form, Formik } from "formik";
import moment from "moment";

export default function TodoComponent(){

    const navigate = useNavigate();

    const authContext = useAuth()

    const username = authContext.username;

    const {id} = useParams() //destructuring assign for object

    const[description, setDescription] = useState('')

    const[targetDate, setTargetDate] = useState('')

    const retriveTodoForUsername = useCallback(() => {
       if(id > 0){
            apiRetriveTodoForUsername(username, id)
            .then(response => {
                console.log(response)
                setDescription(response.data.description)
                setTargetDate(response.data.targetDate)
            })
            .catch(error => console.log(error))
       }
    }, [username, id])

    useEffect(
        () => retriveTodoForUsername(),
        [id, retriveTodoForUsername]
    )

    function saveTodo(values){

        console.log('save triggered')
        console.log(values)

        //object fields should have the same name as in the backend object to ensure mappig
        const todo = {
            id: id,
            username: username,
            description: values.description,
            targetDate: values.targetDate,
            done: false
        }

        console.log(todo)
        
        if(id > 0){
            apiUpdateTodo(username, id, todo)
                .then(response => {
                    console.log(response)
                    navigate(`/todos/${username}`)
                })
                .catch(error => console.log(error))
        }else{
            apiCreateTodo(username, todo)
                .then(response => {
                    navigate(`/todos/${username}`)
                })
                .catch(error => console.log)
        }
    }

    function validateFields(values){
        console.log('validate triggered')
        
        let errors = {
            //description : 'Enter a valid description',
            //targetDate: 'Enter a valid target date'
        }

        if(values.description.length < 5){
            errors.description = 'Descriptions should be at least 5 characters long'
        }

        if(values.targetDate == null || values.targetDate===''
            || !moment(values.targetDate).isValid()
        ){
            errors.targetDate = 'A todo must have a future target date'
        }

        console.log(values)
        return errors
    }

    return(
        <div className="container">
            <h1>Enter Todo details</h1>
            <div>
            <Formik initialValues={{description, targetDate}} 
                    enableReinitialize = {true}
                    onSubmit={saveTodo}
                    validate={validateFields}
                    validateOnChange = {false}  //prevents validation while typing. Validates on submit only
                    validateOnBlur = {false}    //prevents validation while the filed does not have focus
                    >
                {/* by default, Formik initial values are the ones given by useState. 
                    Thus we need to configure it to re-initialize*/}
                {
                    <Form>
                        <ErrorMessage name="description" component="div" className="alert alert-warning"/>
                        <ErrorMessage name="targetDate" component="div" className="alert alert-warning"/>
                        <fieldset className="form-group">
                            <label>Description</label>
                            <Field type="text" className="form-control" name="description"/>
                        </fieldset>
                        <fieldset className="form-group">
                            <label>Target Date</label>
                            <Field type="date" className="form-control" name="targetDate"/>
                        </fieldset>
                        <div>
                            <button className="btn btn-success m-5" type="submit">Save</button>
                        </div>
                    </Form>
                }
            </Formik>
            </div>
        </div>
    )
}