//EX18
// Define the Enum
enum MyHttpStatusCode {
    OK = 200,
    NOTFOUND = 404,
    ACCESSDENIED = 403,
    INTERNALERROR = 500
}

// Example usage:
console.log("OK:", HttpStatusCode.OK);                   // 200
console.log("Not Found:", HttpStatusCode.NOTFOUND);      // 404
console.log("Access Denied:", HttpStatusCode.ACCESSDENIED); // 403
console.log("Internal Error:", HttpStatusCode.INTERNALERROR); // 500

// Using Enum in a function
function getHttpMessage(code: HttpStatusCode): string {
    switch(code) {
        case HttpStatusCode.OK:
            return "Request successful.";
        case HttpStatusCode.NOTFOUND:
            return "Resource not found.";
        case HttpStatusCode.ACCESSDENIED:
            return "Access denied.";
        case HttpStatusCode.INTERNALERROR:
            return "Internal server error.";
        default:
            return "Unknown status code.";
    }
}

console.log(getHttpMessage(HttpStatusCode.OK)); // Request successful.
console.log(getHttpMessage(HttpStatusCode.NOTFOUND)); // Resource not found.
