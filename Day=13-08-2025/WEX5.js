// Global scope variable
var x = 4;

// Constant variable
const z = 9;

function f() {
    // Changing global x
    x = 9;

    // Block scope variable
    let y = 8;

    console.log("x in function is " + x); // accessible
    console.log("y in function is " + y); // accessible

    if (true) {
        let z = 18; // block scoped
        console.log("y in if block is " + y); // accessible
        console.log("z in if block is " + z); // accessible only inside if
    }

    console.log("z in function is " + z); // global const z is accessible here
}

f(); // function call

console.log("x outside function is " + x); // updated global value
// console.log("y outside function is " + y); // ❌ will throw error (block scoped)
console.log("z outside function is " + z); // global const z
