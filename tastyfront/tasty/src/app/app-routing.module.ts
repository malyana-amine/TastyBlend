import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { TestComponent } from './layout/test/test.component';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';
import { AuthGuard } from './guards/auth.guard';
import { PostRecipeComponent } from './components/post-recipe/post-recipe.component';
import { PostComponent } from './components/post/post.component';
import { UserProfilComponent } from './components/user-profil/user-profil.component';

const routes: Routes = [
  {path:"", component:LoginComponent},
  {path:"signup", component:RegisterComponent},
  {path:"post", component:PostComponent},
  {path:"test" , component:TestComponent ,canActivate: [AuthGuard]},
  {path:"addRecipe" , component:PostRecipeComponent, canActivate: [AuthGuard]},
  {path:"requests" , component:UserProfilComponent, canActivate: [AuthGuard]}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { } 