// Get references to elements
const loginBtn = document.getElementById("loginBtn");
const logoutBtn = document.getElementById("logoutBtn");
const userIdInput = document.getElementById("userId");
const passwordInput = document.getElementById("password");
const messageDiv = document.getElementById("message");

// Login button click
loginBtn.addEventListener("click", () => {
    const userId = userIdInput.value.trim();
    const password = passwordInput.value.trim();

    if (userId === "" || password === "") {
        messageDiv.style.color = "red";
        messageDiv.textContent = "User ID and Password cannot be empty.";
        return;
    }

    // Store userId in localStorage
    localStorage.setItem("userId", userId);
    messageDiv.style.color = "green";
    messageDiv.textContent = `Logged in as ${userId}`;
});

// Logout button click
logoutBtn.addEventListener("click", () => {
    localStorage.removeItem("userId");
    messageDiv.style.color = "blue";
    messageDiv.textContent = "Logged out successfully";
    userIdInput.value = "";
    passwordInput.value = "";
});

// Optional: Show if user is already logged in
const storedUser = localStorage.getItem("userId");
if (storedUser) {
    messageDiv.style.color = "green";
    messageDiv.textContent = `Already logged in as ${storedUser}`;
}
