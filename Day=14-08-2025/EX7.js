let obj1 = { a: 1, b: 2 };
let obj2 = { b: 3, c: 4 };

// Merge using spread operator
let mergedObj = { ...obj1, ...obj2 };

console.log("Merged Object:", mergedObj);
