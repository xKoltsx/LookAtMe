import {UserRole} from "./UserRole";

export class UserResponse {
  public id:number;
  public username: string;
  public email: string;
  public role: UserRole;

  public constructor(id:number, username: string,  email : string,role : UserRole) {
    this.id = id;
    this.username = username;
    this.email = email;
    this.role = role;

  }
}
