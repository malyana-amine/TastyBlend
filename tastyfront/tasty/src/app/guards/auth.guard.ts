import { CanActivate, CanActivateFn, Router } from '@angular/router';
import { AuthService } from '../services/authService/auth.service';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class AuthGuard implements CanActivate {
  constructor(private authService: AuthService, private router: Router) {}

  canActivate(): boolean {
    if (this.authService.isLoggedIn()) {
      return true;
    } else {
      this.router.navigate(['/signup']); // Redirect to login if not authenticated
      return false;
    }
  }
}