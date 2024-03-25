import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { RequRes } from 'src/app/models/requ-res';
import { AuthService } from '../authService/auth.service';

@Injectable({
  providedIn: 'root'
})
export class RequestsService {

  private apiUrl = 'http://127.0.0.1:8080/api/v1/Request';

  constructor(private http: HttpClient,private authService: AuthService) { }

  getRequests(): Observable<RequRes[]> {
    const authToken = this.authService.getAuthToken();
    const headers = new HttpHeaders().set('Authorization', `Bearer ${authToken}`);
    return this.http.get<RequRes[]>(this.apiUrl+`/demande`, { headers });
  }

  acceptRequest(requestId: number): Observable<any> {
    const authToken = this.authService.getAuthToken();
    const headers = new HttpHeaders().set('Authorization', `Bearer ${authToken}`);
    return this.http.put(`${this.apiUrl}/accept/${requestId}`, {}, { headers });
  }

  refuseRequest(requestId: number): Observable<any> {
    const authToken = this.authService.getAuthToken();
    const headers = new HttpHeaders().set('Authorization', `Bearer ${authToken}`);
    return this.http.put(`${this.apiUrl}/reject/${requestId}`, {}, { headers });
  }


  addFriendOrSendRequest(userId: number): Observable<any> {
    const authToken = this.authService.getAuthToken();  // Get token from AuthService
    const headers = new HttpHeaders()
      .set('Authorization', `Bearer ${authToken}`)
      .set('Content-Type', 'application/json');  // Assuming sending data
    return this.http.post<any>(`${this.apiUrl}/${userId}`, {}, { headers });
  }

}
