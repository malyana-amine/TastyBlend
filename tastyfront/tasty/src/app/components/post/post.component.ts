import { NgFor } from '@angular/common';
import { HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { RecipeResponse } from 'src/app/models/recipeResponse';
import { AuthService } from 'src/app/services/authService/auth.service';
import { RecipeService } from 'src/app/services/recipe/recipe.service';

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

  constructor(private recipeService: RecipeService,private authService: AuthService) { }

  ngOnInit(): void {
    this.getRecipes();
  }

  getRecipes(): void {
    this.recipeService.getRecipes()
      .subscribe(recipes => this.recipes = recipes);
  }
}
