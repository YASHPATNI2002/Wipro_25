
let persons = [
    { name: "Yash Patani", age: 22, city: "Mumbai" },
    { name: "Shravani", age: 17, city: "Pune" },
    { name: "Rohan", age: 19, city: "Delhi" },
    { name: "Priya", age: 16, city: "Bangalore" },
    { name: "Ankit", age: 25, city: "Chennai" }
];

// Filter people eligible to vote (age >= 18)
let eligibleVoters = persons.filter(person => person.age >= 18);

// Display result in console
console.log("All Persons:", persons);
console.log("Eligible Voters:", eligibleVoters);
