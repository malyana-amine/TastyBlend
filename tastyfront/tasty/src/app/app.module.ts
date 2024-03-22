import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TestComponent } from './layout/test/test.component';
import { TerrazzoBackgroundComponent } from './layout/terrazzo-background/terrazzo-background.component';
import { FormsModule } from '@angular/forms';
import { RegisterComponent } from './components/register/register.component';
import { SignupComponent } from './components/signup/signup.component';
import { HttpClientModule } from '@angular/common/http';
import { AuthService } from './services/authService/auth.service';
import { LoginComponent } from './components/login/login.component';
import { CommonModule, NgFor } from '@angular/common';
import { PostRecipeComponent } from './components/post-recipe/post-recipe.component';
import { PostComponent } from './components/post/post.component';

@NgModule({
    declarations: [
        AppComponent,
        TestComponent,
        TerrazzoBackgroundComponent,
        RegisterComponent,
        SignupComponent,
        LoginComponent,
        PostRecipeComponent,
        // PostComponent
    ],
    providers: [AuthService],
    bootstrap: [AppComponent],
    imports: [
        BrowserModule,
        AppRoutingModule,
        FormsModule,
        HttpClientModule,
        CommonModule,
        NgFor,
        PostComponent
    ]
})
export class AppModule { }
