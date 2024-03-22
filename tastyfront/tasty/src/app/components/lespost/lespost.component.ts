import { Component, OnInit } from '@angular/core';
import { RecipeResponse } from 'src/app/models/recipeResponse';
import { RecipeService } from 'src/app/services/recipe/recipe.service';

@Component({
  selector: 'app-lespost',
  standalone: true,
  imports: [],
  templateUrl: './lespost.component.html',
  styleUrl: './lespost.component.css'
})
export class LespostComponent implements OnInit {

  recipes: RecipeResponse[] | undefined;

  constructor(private recipeService: RecipeService) { }

  ngOnInit(): void {
    this.getRecipes();
  }

  getRecipes(): void {
    this.recipeService.getRecipes()
      .subscribe(recipes => this.recipes = recipes);
  }
}
