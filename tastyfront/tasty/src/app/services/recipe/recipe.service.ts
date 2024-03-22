import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { RecipeResponse } from 'src/app/models/recipeResponse';
import { AuthService } from '../authService/auth.service';

@Injectable({
  providedIn: 'root'
})
export class RecipeService {

  private apiUrl = 'http://127.0.0.1:8080/api/v1/recipe';

  constructor(private http: HttpClient,private authService: AuthService) { }

  saveRecipe(formData: FormData, headers: HttpHeaders): Observable<any> {
    const options = { headers: headers }; // Create options object with headers
    return this.http.post<any>(`${this.apiUrl}/add`, formData, options); // Pass options to the post method
  }

  getRecipes(): Observable<RecipeResponse[]> {
    const authToken = this.authService.getAuthToken();
    const headers = new HttpHeaders().set('Authorization', `Bearer ${authToken}`);
    return this.http.get<RecipeResponse[]>(this.apiUrl, { headers });
  }

  getImageUrl(imageUrl: string): Observable<string> {
    // Construct the API endpoint for retrieving images (remove curly braces)
    const imageApiUrl = `${this.apiUrl}/images/${imageUrl}`;

    // Make a GET request to the image retrieval endpoint
    return this.http.get<string>(imageApiUrl);
  }

}
