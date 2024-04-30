import {UserRole} from "../UserRole";

export class UserRequest {
  username: string;
  password: string;
  email: string;

  constructor(username: string, password: string,email: string) {
    this.username = username;
    this.password = password;
    this.email = email;
  }
}
