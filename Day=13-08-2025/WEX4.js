let maxLength = 50;

document.getElementById("myInput").addEventListener("input", function() {
    let remaining = maxLength - this.value.length;
    document.getElementById("charCount").innerHTML = remaining + " characters remaining";
});
