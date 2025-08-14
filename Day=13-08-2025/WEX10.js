// Person list from Ex 7
let persons = [
    { name: "Yash Patani", age: 22, city: "Mumbai" },
    { name: "Shravani", age: 17, city: "Pune" },
    { name: "Rohan", age: 19, city: "Delhi" },
    { name: "Priya", age: 16, city: "Bangalore" },
    { name: "Ankit", age: 25, city: "Chennai" }
];

// Using map to add status
let updatedPersons = persons.map(person => {
    return {
        ...person,
        status: person.age >= 18 ? "Adult" : "Minor"
    };
});

// Display updated list
console.log("Updated Person List with Status (Map):", updatedPersons);
