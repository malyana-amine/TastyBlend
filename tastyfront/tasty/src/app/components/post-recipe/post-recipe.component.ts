import { HttpHeaders } from '@angular/common/http';
import { Component } from '@angular/core';
import { Recipe } from 'src/app/models/recipe';
import { AuthService } from 'src/app/services/authService/auth.service';
import { RecipeService } from 'src/app/services/recipe/recipe.service';

@Component({
  selector: 'app-post-recipe',
  templateUrl: './post-recipe.component.html',
  styleUrls: ['./post-recipe.component.css']
})
export class PostRecipeComponent {

  formData: Recipe = { article: '', preparationSteps: '', ingredients: '', images: [] };
  selectedImages: File[] = [];

  constructor(
    private recipeService: RecipeService,
    private authService: AuthService // Inject AuthService
  ) {}

  onSubmit() {
    const authToken = this.authService.getAuthToken();
    const headers = new HttpHeaders().set('Authorization', `Bearer ${authToken}`);

    const formData = new FormData();
    formData.append('article', this.formData.article);
    formData.append('preparationSteps', this.formData.preparationSteps);
    formData.append('ingredients', this.formData.ingredients);
    
    for (let i = 0; i < this.selectedImages.length; i++) {
      formData.append('imageUrl', this.selectedImages[i]); // Keep 'imageUrl' to match backend
    }    
    this.recipeService.saveRecipe(formData, headers).subscribe(
      (response) => {
        console.log('Recipe saved successfully:', response);
        this.formData = { article: '', preparationSteps: '', ingredients: '', images: [] };
        this.selectedImages = [];
      },
      (error) => {
        console.error('Error saving recipe:', error);
      }
    );
  }

  onFileChange(event: any) {
    this.selectedImages = []; // Clear previous selected images

    // Read selected files and display image previews
    if (event.target.files && event.target.files.length > 0) {
      for (let i = 0; i < event.target.files.length; i++) {
        const file = event.target.files[i];
        const reader = new FileReader();

        reader.onload = (e: any) => {
          this.selectedImages.push(file);
        };

        reader.readAsDataURL(file);
      }
    }
  }
}
