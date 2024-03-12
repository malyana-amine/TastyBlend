// register.component.ts

import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/models/User';
import { AuthService } from 'src/app/services/authService/auth.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css'],
})
export class RegisterComponent {
user: User = new User();
  // user: any;

  constructor(private registrationService: AuthService , private router: Router) {}

  registerUser() {
    this.registrationService.registerUser(this.user)
      .subscribe(response => {
        console.log('Registration successful', response);
        this.router.navigate(['/']);
      }, error => {
        console.error('Registration failed', error);
      });
  }
}
