function checkLength() {
    let text = document.getElementById("myInput").value;
    let length = text.length;
    document.getElementById("result").innerHTML = "Length: " + length;
}
