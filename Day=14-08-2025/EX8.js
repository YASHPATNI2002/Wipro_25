let arr1 = [1, 2, 3];
let arr2 = [4, 5, 6];

// Creating a new array with additional elements in between
let newArr = [4, 5, ...arr1, 6, 7, ...arr2, 8, 9];

console.log("New Array:", newArr);
