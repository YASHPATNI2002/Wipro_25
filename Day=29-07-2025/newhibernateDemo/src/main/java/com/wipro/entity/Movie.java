package com.wipro.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="movie")
public class Movie {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;	
	@Column(name="movie_name")
	String movieName;	
	@Column(name="movie_language")
	String movieLanguage;
	@Column(name="imdb_rating")
	double imdbRating;

	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Movie(String movieName, String movieLanguage, double imdbRating) {
		super();	
		this.movieName = movieName;
		this.movieLanguage = movieLanguage;
		this.imdbRating = imdbRating;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getMovieLanguage() {
		return movieLanguage;
	}
	public void setMovieLanguage(String movieLanguage) {
		this.movieLanguage = movieLanguage;
	}
	public double getImdbRating() {
		return imdbRating;
	}
	public void setImdbRating(double imdbRating) {
		this.imdbRating = imdbRating;
	}
	@Override
	public String toString() {
		return "Movie [id=" + id + ", movieName=" + movieName + ", movieLanguage=" + movieLanguage + ", imdbRating="
				+ imdbRating + "]";
	}
	
	
	
	

}
