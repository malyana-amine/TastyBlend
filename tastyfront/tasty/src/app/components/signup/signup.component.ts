import { Component } from '@angular/core';
import { AuthService } from 'src/app/services/authService/auth.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent {

  user: any;
  // user: any;

  constructor(private registrationService: AuthService) {}

  registerUser() {
    this.registrationService.registerUser(this.user)
      .subscribe(response => {
        console.log('Registration successful', response);
      }, error => {
        console.error('Registration failed', error);
      });
  }
}
