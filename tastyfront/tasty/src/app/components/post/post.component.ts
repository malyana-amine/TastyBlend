import { NgFor } from '@angular/common';
import { HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { RecipeResponse } from 'src/app/models/recipeResponse';
import { AuthService } from 'src/app/services/authService/auth.service';
import { RecipeService } from 'src/app/services/recipe/recipe.service';
import { RequestsService } from 'src/app/services/requests/requests.service';

@Component({
  selector: 'app-post',
  standalone: true,
  imports: [NgFor],
  templateUrl: './post.component.html',
  styleUrl: './post.component.css'
})
export class PostComponent implements OnInit {

  recipes: RecipeResponse[] | undefined;
  imageRecipe : String | undefined;

  constructor(private recipeService: RecipeService,private authService: AuthService,private requestsService: RequestsService ) { }

  ngOnInit(): void {
    this.getRecipes();
  }

  getRecipes(): void {
    this.recipeService.getRecipes()
      .subscribe(recipes => this.recipes = recipes);
  }

  addFriendOrSendRequest(userId: number) {
    this.requestsService.addFriendOrSendRequest(userId).subscribe(
      () => {
        console.log('Friend added or request sent successfully');
        // Optionally, you can update UI or show a success message
      },
      (error) => {
        console.error('Error adding friend or sending request: ', error);
      }
    );
  }
}
