import { Injectable } from '@angular/core';
import { Observable, firstValueFrom } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { tap } from 'rxjs/operators';
import { LoginReq } from 'src/app/models/LoginReq';
import { Router } from '@angular/router';
import { AppStateService } from '../appState/app-state.service';
import { jwtDecode } from 'jwt-decode';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private apiUrl = 'http://127.0.0.1:8080/api/v1/auth';

  private token: string | null = null;
  private roles: string[] = [];

  constructor(private router: Router, private http: HttpClient, private appState: AppStateService) {
    this.token = localStorage.getItem('token');
  }

  registerUser(user: any): Observable<any> {
    return this.http.post(`${this.apiUrl}/register`, user);
  }

  async login(user: LoginReq): Promise<boolean> {
    try {
      const loginResponse = await firstValueFrom(this.http.post<any>(`${this.apiUrl}/authenticate`, user));

      if (!loginResponse || !loginResponse.access_token || !loginResponse.refresh_token) {
        throw new Error("Invalid login response: Tokens not found");
      }

      const accessToken = loginResponse.access_token;
      const refreshToken = loginResponse.refresh_token;

      localStorage.setItem('token', accessToken);
      localStorage.setItem('refreshToken', refreshToken);

      this.token = accessToken;

      const decodedJwt: any = jwtDecode(accessToken);
      this.roles = decodedJwt.roles || [];

      
      console.log(this.roles);
      console.log(decodedJwt);
      
      this.appState.setAuthState({
        isAuthenticated: true,
        username: decodedJwt.sub,
        roles: this.roles,
        token: accessToken
      });

      return true;
    } catch (error) {
      console.error(error);
      throw new Error("Login failed. Please check your credentials.");
    }
  }

  logout() {
    localStorage.removeItem('token');
    localStorage.removeItem('refreshToken');

    this.token = null;

    this.appState.setAuthState({
      isAuthenticated: false,
      username: undefined,
      roles: [],
      token: undefined
    });

    this.router.navigateByUrl('/login');
  }

  isAuthenticated(): boolean {
    return !!this.token;
  }

  getUserRoles(): string[] {
    return this.roles;
  }
}
