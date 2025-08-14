let employees = [
    { name: "Yash Patani", role: "Manager", empId: 101, salary: 75000 },
    { name: "Shravani", role: "Developer", empId: 102, salary: 55000 },
    { name: "Rohan", role: "QA", empId: 103, salary: 50000 },
    { name: "Priya", role: "Manager", empId: 104, salary: 80000 },
    { name: "Ankit", role: "Developer", empId: 105, salary: 60000 },
    { name: "Meera", role: "Manager", empId: 106, salary: 72000 }
];


let totalManagerSalary = employees
    .filter(emp => emp.role === "Manager")
    .reduce((sum, emp) => sum + emp.salary, 0);

console.log("Total Salary drawn by all Managers: ₹" + totalManagerSalary);
