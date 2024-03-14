import { Component } from '@angular/core';

@Component({
  selector: 'app-post-recipe',
  templateUrl: './post-recipe.component.html',
  styleUrls: ['./post-recipe.component.css']
})
export class PostRecipeComponent {

  formData: any = {};
  selectedImages: string[] = [];

  constructor() {}

  onSubmit() {
    // Handle form submission here
    console.log(this.formData);
  }

  onFileChange(event: any) {
    this.selectedImages = []; // Clear previous selected images

    // Read selected files and display image previews
    if (event.target.files && event.target.files.length > 0) {
      for (let i = 0; i < event.target.files.length; i++) {
        const file = event.target.files[i];
        const reader = new FileReader();

        reader.onload = (e: any) => {
          this.selectedImages.push(e.target.result);
        };

        reader.readAsDataURL(file);
      }
    }
  }
}
