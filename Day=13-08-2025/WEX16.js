// Array of image URLs (you can replace with your own)
let images = [
    "https://picsum.photos/id/1015/600/400",
    "https://picsum.photos/id/1016/600/400",
    "https://picsum.photos/id/1025/600/400",
    "https://picsum.photos/id/1035/600/400"
];

let currentIndex = 0;

// Function to update the displayed image
function showImage(index) {
    document.getElementById("galleryImage").src = images[index];
}

// Show the first image on page load
window.onload = function() {
    showImage(currentIndex);
};

// Show next image
function nextImage() {
    currentIndex = (currentIndex + 1) % images.length;
    showImage(currentIndex);
}

// Show previous image
function prevImage() {
    currentIndex = (currentIndex - 1 + images.length) % images.length;
    showImage(currentIndex);
}
