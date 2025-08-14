//EX18
// Define the Enum
var HttpStatusCode;
(function (HttpStatusCode) {
    HttpStatusCode[HttpStatusCode["OK"] = 200] = "OK";
    HttpStatusCode[HttpStatusCode["NOTFOUND"] = 404] = "NOTFOUND";
    HttpStatusCode[HttpStatusCode["ACCESSDENIED"] = 403] = "ACCESSDENIED";
    HttpStatusCode[HttpStatusCode["INTERNALERROR"] = 500] = "INTERNALERROR";
})(HttpStatusCode || (HttpStatusCode = {}));
// Example usage:
console.log("OK:", HttpStatusCode.OK); // 200
console.log("Not Found:", HttpStatusCode.NOTFOUND); // 404
console.log("Access Denied:", HttpStatusCode.ACCESSDENIED); // 403
console.log("Internal Error:", HttpStatusCode.INTERNALERROR); // 500
// Using Enum in a function
function getHttpMessage(code) {
    switch (code) {
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
