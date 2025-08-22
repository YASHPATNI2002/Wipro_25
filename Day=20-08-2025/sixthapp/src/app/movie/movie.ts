import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, NgForm } from '@angular/forms';
import { Movie } from '../Movie';
import { MovieService } from '../services/movie.service';

@Component({
  selector: 'app-movie',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './movie.html',
  styleUrls: ['./movie.css']
})
export class MovieComponent {
  movies: Movie[] = [];
  editingId: number | null = null;

  form: { movieName: string; language: string; imdbRating: number | null } = {
    movieName: '',
    language: '',
    imdbRating: null
  };

  constructor(private movieService: MovieService) {
    this.refresh();
  }

  refresh(): void {
    this.movies = this.movieService.getAll();
  }

  onSubmit(f: NgForm): void {
    if (f.invalid || this.form.imdbRating == null) return;

    const name = this.form.movieName.trim();
    const lang = this.form.language.trim();
    if (!name || !lang) return;

    const rating = Number(this.form.imdbRating);
    if (isNaN(rating) || rating < 0 || rating > 10) return;

    if (this.editingId) {
      this.movieService.update({
        movieId: this.editingId,
        movieName: name,
        language: lang,
        imdbRating: rating
      });
    } else {
      this.movieService.create({
        movieName: name,
        language: lang,
        imdbRating: rating
      });
    }
    this.reset(f);
    this.refresh();
  }

  edit(m: Movie): void {
    this.editingId = m.movieId;
    this.form.movieName = m.movieName;
    this.form.language = m.language;
    this.form.imdbRating = m.imdbRating;
  }

  remove(id: number): void {
    this.movieService.delete(id);
    if (this.editingId === id) this.editingId = null;
    this.refresh();
  }

  reset(f: NgForm): void {
    f.resetForm();
    this.editingId = null;
    this.form = { movieName: '', language: '', imdbRating: null };
  }

  trackById = (_: number, m: Movie) => m.movieId;
}
