import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { tap, catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private apiUrl = 'http://127.0.0.1:8080/api/v1/auth';

  // Assume you store the authentication status and token in variables
  private isAuthenticated = false;
  private authToken: string | null = null;

  constructor(private http: HttpClient) {}

  registerUser(user: any): Observable<any> {
    return this.http.post(`${this.apiUrl}/register`, user);
  }

  login(credentials: any): Observable<any> {
    return this.http.post<any>(`${this.apiUrl}/login`, credentials).pipe(
      tap(response => {
        this.setAuthenticated(true);
        this.setAuthToken(response.token);
      }),
      catchError(error => {
        console.error('Login failed', error);
        return of(null);
      })
    );
  }
  

  logout(): void {
    this.setAuthenticated(false);
    this.setAuthToken(null);
  }

  isLoggedIn(): boolean {
    return this.isAuthenticated;
  }

  getToken(): string | null {
    return this.authToken;
  }

  // Helper method to set the authentication status
  private setAuthenticated(status: boolean): void {
    this.isAuthenticated = status;
  }

  // Helper method to set the authentication token
  private setAuthToken(token: string | null): void {
    this.authToken = token;
  }
}
