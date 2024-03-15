import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RecipeService {

  private apiUrl = 'http://127.0.0.1:8080/api/v1/recipe';

  constructor(private http: HttpClient) { }

  saveRecipe(formData: FormData, headers: HttpHeaders): Observable<any> {
    const options = { headers: headers }; // Create options object with headers
    return this.http.post<any>(`${this.apiUrl}/add`, formData, options); // Pass options to the post method
  }
}
