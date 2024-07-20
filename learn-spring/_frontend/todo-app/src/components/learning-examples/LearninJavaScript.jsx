const person={

    name: 'Leo',
    age: 39,
    address: {
        city: 'Porto Alegre',
        country: 'Brazil'
    },
    profiles: ['instagram', 'facebook', 'linkedin'],
    printProfile: () => {
        //console.log(person.profiles[2])
        person.profiles.map(
            //if there is only one parameter
            profile => console.log(profile)
            //else
            //(profile) => {
            //    console.log(profile)
            //}
        )
    }
}

export default function LearningJavaScript(){
    return(
        <div>
            <div>{person.name}</div>
            <div>{person.age}</div>
            <div>{person.address.city}</div>
            <div>{person.address.country}</div>
            <div>{person.profiles[0]}</div>
            <div>{person.printProfile()}</div>
        </div>
    )

}