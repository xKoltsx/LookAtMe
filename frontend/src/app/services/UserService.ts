import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Injectable} from "@angular/core";
import {AbstractService} from "./AbstcractService";
import {User} from "../models/User";
import {UserRequest} from "../models/request/UserRequest";


@Injectable({
  providedIn: 'root',
})
export class UserService extends AbstractService<User, UserRequest>{
  constructor(http: HttpClient) {
    super(http, 'http://localhost:8080/user');
  }

}
