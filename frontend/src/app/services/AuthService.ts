import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { map, catchError } from 'rxjs/operators';
import { User } from '../models/User';
import { UserResponse } from '../models/UserResponse';

@Injectable({
  providedIn: 'root',
})
export class AuthService {

  private url: string = 'http://localhost:8080/auth'; // URL для вашого API

  constructor(private http: HttpClient) {}

  public login(username: string, password: string): Observable<User | null> {
    return this.http.post<UserResponse>(`${this.url}/login`, { username, password }).pipe(
      map((response: UserResponse) => {
        if (response && response.id) {
          const user = User.fromObjectToModel(response);
          user.role = response.role;
          localStorage.setItem('currentUser', JSON.stringify(user));
          return user;
        }
        return null;
      }),
      catchError(error => {
        console.error('Error during login:', error);
        return of(null);
      })
    );
  }



  public logout(): void {
    localStorage.removeItem('currentUser'); // Видаляємо дані про поточного користувача з локального сховища
  }

  public getCurrentUser(): User | null {
    const storedUser = localStorage.getItem('currentUser');
    return storedUser ? JSON.parse(storedUser) : null; // Повертаємо поточного користувача, якщо він збережений у локальному сховищі, без пароля
  }

  public register(username: string, email: string, password: string): Observable<User | null> {
    return this.http.post<UserResponse>(`${this.url}/register`, { username, email, password }).pipe(
      map((response: UserResponse) => {
        if (response && response.id) {
          const user = User.fromObjectToModel(response);
          user.role = response.role; // Задаємо роль, якщо потрібно
          localStorage.setItem('currentUser', JSON.stringify(user));
          return user;
        }
        return null;
      }),
      catchError(error => {
        console.error('Error during registration:', error);
        return of(null);
      })
    );
  }
}
