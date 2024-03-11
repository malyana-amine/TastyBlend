import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { LoginReq } from 'src/app/models/LoginReq';
import { AuthService } from 'src/app/services/authService/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  userReq: LoginReq = new LoginReq();

  constructor(private authService: AuthService, private router: Router) {}

  login(): void {
    this.authService.login(this.userReq).subscribe(
      response => {
        if (response) {
          this.router.navigate(['/test']);
        } else {
          // Handle login failure
        }
      },
      error => {
        console.error('Login failed', error);
        // Handle error or display a message
      }
    );
  }
}
