function validateEmail() {
    let email = document.getElementById("email").value.trim();
    let emailError = document.getElementById("emailError");
    let emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/; // simple email regex

    if (email === "") {
        emailError.innerHTML = "Email is required";
        emailError.style.visibility = "visible";
        return false;
    } else if (!emailPattern.test(email)) {
        emailError.innerHTML = "Invalid email format";
        emailError.style.visibility = "visible";
        return false;
    } else {
        emailError.style.visibility = "hidden";
        return true;
    }
}

function validatePassword() {
    let password = document.getElementById("password").value.trim();
    let passwordError = document.getElementById("passwordError");

    if (password === "") {
        passwordError.innerHTML = "Password is required";
        passwordError.style.visibility = "visible";
        return false;
    } else {
        passwordError.style.visibility = "hidden";
        return true;
    }
}

function validateForm() {
    let emailValid = validateEmail();
    let passwordValid = validatePassword();

    if (emailValid && passwordValid) {
        alert("Login successful!");
    } else {
        alert("Please correct the errors before submitting.");
    }
}
