import { CanActivate, CanActivateFn, Router } from '@angular/router';
import { AuthService } from '../services/authService/auth.service';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class AuthGuard implements CanActivate {
  constructor(private authService: AuthService, private router: Router) {}

  canActivate(): boolean {
    console.log('zeafaezrazeazefazefazefazefzaef');
    console.log(this.authService.isLoggedIn());
    if (this.authService.isLoggedIn()) {
      console.log(this.authService.isLoggedIn());
      console.log('zeafaezrazeazefazefazefazefzaef');
      return true;
    } else {
      this.router.navigate(['/signup']);
      return false;
    }
  }
}