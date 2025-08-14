// Function to separate first argument and rest using rest operator
function separateFirstRest(first, ...rest) {
    return { first, rest };
}


console.log(separateFirstRest(10, 20, 30, 40)); 

console.log(separateFirstRest("apple", "banana", "cherry", "date")); 
