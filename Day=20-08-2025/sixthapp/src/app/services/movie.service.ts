import { Injectable } from '@angular/core';
import { Movie } from '../Movie';

@Injectable({
  providedIn: 'root'
})
export class MovieService {
  private movies: Movie[] = [
    { movieId: 1, movieName: 'Inception', language: 'English', imdbRating: 8.8 },
    { movieId: 2, movieName: '3 Idiots', language: 'Hindi', imdbRating: 8.4 }
  ];
  private nextId = 3;

  getAll(): Movie[] {
    return [...this.movies];
  }

  getById(id: number): Movie | undefined {
    return this.movies.find(m => m.movieId === id);
  }

  create(movie: Omit<Movie, 'movieId'>): Movie {
    const newMovie: Movie = { movieId: this.nextId++, ...movie };
    this.movies.push(newMovie);
    return newMovie;
  }

  update(movie: Movie): boolean {
    const idx = this.movies.findIndex(m => m.movieId === movie.movieId);
    if (idx === -1) return false;
    this.movies[idx] = { ...movie };
    return true;
  }

  delete(id: number): void {
    this.movies = this.movies.filter(m => m.movieId !== id);
  }
}
