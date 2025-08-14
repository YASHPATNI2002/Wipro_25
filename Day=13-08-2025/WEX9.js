// Person list from Ex 7
let persons = [
    { name: "Yash Patani", age: 22, city: "Mumbai" },
    { name: "Shravani", age: 17, city: "Pune" },
    { name: "Rohan", age: 19, city: "Delhi" },
    { name: "Priya", age: 16, city: "Bangalore" },
    { name: "Ankit", age: 25, city: "Chennai" }
];

for (let i = 0; i < persons.length; i++) {
    if (persons[i].age >= 18) {
        persons[i].status = "Adult";
    } else {
        persons[i].status = "Minor";
    }
}


// Display updated list
console.log("Updated Person List with Status (Map):", updatedPersons);
