import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators, ReactiveFormsModule } from '@angular/forms';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule }      from '@angular/material/input';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatNativeDateModule } from '@angular/material/core';
import { MatSelectModule }     from '@angular/material/select';
import { MatButtonModule }     from '@angular/material/button';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-ex4',
  standalone: true,
  imports: [
    CommonModule,
    ReactiveFormsModule,
    MatFormFieldModule,
    MatInputModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatSelectModule,
    MatButtonModule
  ],
  templateUrl: './ex4.html',
  styleUrls: ['./ex4.css']
})
export class Ex4Component {
  form: FormGroup;
  subjects = ['Computer Science', 'Mathematics', 'Physics', 'Chemistry', 'Biology'];
  minDob = new Date(1970, 0, 1);
  maxDob = new Date();

  constructor(private fb: FormBuilder) {
    this.form = this.fb.group({
      name: ['', [Validators.required, Validators.minLength(2)]],
      email: ['', [Validators.required, Validators.email]],
      dob: [null, [Validators.required]],
      subject: ['', [Validators.required]],
    });
  }

  get f() { return this.form.controls; }

  submit() {
  this.form.markAllAsTouched(); 
  if (this.form.invalid) return;

  console.log('Registration data:', this.form.value);
}

  reset() {
    this.form.reset();
  }
}
