import {UserRole} from "./UserRole";

export class User {
  id : number;
  username : string;
  password: string;
  email: string;

  role : UserRole;

  constructor(id: number, username: string, password: string,email: string, role : UserRole) {
       this.id = id;
       this.username = username;
       this.password = password;
       this.email = email;
       this.role  = role;
  }

  public static fromObjectToModel(user:any): User{
    return new User(
      user.id,
      user.username,
      user.password,
      user.email,
      user.role
    )
  }

  public isAdmin(): boolean{
    return this.role == UserRole.ROLE_ADMIN;
  }
}
