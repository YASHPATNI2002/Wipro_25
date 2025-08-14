// Function to check if a string is a palindrome
function isPalindrome(str) {
    // Remove spaces and convert to lowercase for uniform comparison
    let cleanedStr = str.replace(/\s+/g, '').toLowerCase();
    
    // Reverse the string
    let reversedStr = cleanedStr.split('').reverse().join('');
    
    // Check if reversed string matches original
    return cleanedStr === reversedStr;
}

// Test examples
let test1 = "madam";
let test2 = "hello";
let test3 = "A man a plan a canal Panama";

console.log(`${test1} is palindrome?`, isPalindrome(test1)); // true
console.log(`${test2} is palindrome?`, isPalindrome(test2)); // false
console.log(`"${test3}" is palindrome?`, isPalindrome(test3)); // true
