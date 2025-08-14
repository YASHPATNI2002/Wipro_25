// Define the Employee interface
interface Employee {
    empId: number;
    empName: string;
    salary: number;
}

// Create a list of employees
const employees: Employee[] = [
    { empId: 101, empName: "John Doe", salary: 50000 },
    { empId: 102, empName: "Jane Smith", salary: 60000 },
    { empId: 103, empName: "Mark Freeman", salary: 55000 },
];

// Function to print employees and return count
function printEmployees(empList: Employee[]): number {
    console.log("Employee List:");
    empList.forEach(emp => {
        console.log(`ID: ${emp.empId}, Name: ${emp.empName}, Salary: ${emp.salary}`);
    });
    return empList.length;
}

// Call the function
const totalEmployees = printEmployees(employees);
console.log("Total Employees:", totalEmployees);
