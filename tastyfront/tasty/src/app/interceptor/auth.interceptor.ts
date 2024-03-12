import { Injectable } from '@angular/core';
import {
  HttpInterceptor,
  HttpRequest,
  HttpHandler,
  HttpEvent,
} from '@angular/common/http';
import { Observable, finalize } from 'rxjs';
import { AuthService } from '../services/authService/auth.service';
import { LoadingService } from '../services/Loading/loading.service';

@Injectable()
export class AppHttpInterceptor implements HttpInterceptor {

  constructor(private loadingService:LoadingService) {}

  intercept(request: HttpRequest<unknown>, next: HttpHandler): Observable<HttpEvent<unknown>> {
    this.loadingService.showLoadingSpinner();
    let req = request.clone({
      headers : request.headers.set("Authorization","Bearer JWT")
    });
    return next.handle(req).pipe(
      finalize(()=>{
        this.loadingService.hideLoadingSpinner();
      })
    );
  }
}