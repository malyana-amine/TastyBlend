import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { TestComponent } from './layout/test/test.component';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';
import { AuthGuard } from './guards/auth.guard';
import { PostRecipeComponent } from './components/post-recipe/post-recipe.component';

const routes: Routes = [
  {path:"", component:LoginComponent},
  {path:"signup", component:RegisterComponent},
  {path:"test" , component:TestComponent ,canActivate: [AuthGuard]},
  {path:"addRecipe" , component:PostRecipeComponent, canActivate: [AuthGuard]}
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { } 