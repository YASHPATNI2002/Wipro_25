// Create a list of employees
var employees = [
    { empId: 101, empName: "John Doe", salary: 50000 },
    { empId: 102, empName: "Jane Smith", salary: 60000 },
    { empId: 103, empName: "Mark Freeman", salary: 55000 },
];
// Function to print employees and return count
function printEmployees(empList) {
    console.log("Employee List:");
    empList.forEach(function (emp) {
        console.log("ID: ".concat(emp.empId, ", Name: ").concat(emp.empName, ", Salary: ").concat(emp.salary));
    });
    return empList.length;
}
// Call the function
var totalEmployees = printEmployees(employees);
console.log("Total Employees:", totalEmployees);
