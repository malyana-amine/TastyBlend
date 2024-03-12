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
    console.log(this.authService.isAuthenticated());
    if (this.authService.isAuthenticated()) {
      console.log(this.authService.isAuthenticated());
      console.log('zeafaezrazeazefazefazefazefzaef');
      return true;
    } else {
      this.router.navigate(['/signup']);
      return false;
    }
  }
}