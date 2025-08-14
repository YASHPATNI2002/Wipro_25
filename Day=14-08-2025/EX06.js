//  object
let movie = {
    movieName: "Inception",
    movieLanguage: "English",
    imdbRating: 8.8
};

// Destructuring 
let { movieName, movieLanguage, imdbRating } = movie;

// Printing 
console.log("Movie Name:", movieName);
console.log("Language:", movieLanguage);
console.log("IMDB Rating:", imdbRating);
