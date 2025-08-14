// List of names
let names = ["Yash", "Shravani", "Gopin", "Priya", "Alexander", "John", "Meera"];

// Filter names with length > 5 and convert to uppercase
let longNamesUppercase = names
    .filter(name => name.length > 5)
    .map(name => name.toUpperCase());

// Print result
console.log("Original Names:", names);
console.log("Filtered & Uppercase Names:", longNamesUppercase);
