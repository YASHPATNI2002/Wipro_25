// Array of city names (unordered)
let cities = ["Mumbai", "Delhi", "Bangalore", "Chennai", "Kolkata", "Pune"];

// Function to populate dropdown with sorted city names
function populateDropdown() {
    let dropdown = document.getElementById("cityDropdown");

    // Clear previous options except the first
    dropdown.length = 1;

    // Sort the city array alphabetically
    let sortedCities = cities.slice().sort();

    // Add each city as an option
    sortedCities.forEach(city => {
        let option = document.createElement("option");
        option.text = city;
        option.value = city.toLowerCase();
        dropdown.add(option);
    });
}
