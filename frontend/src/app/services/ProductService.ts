import {HttpClient} from "@angular/common/http";
import {Injectable} from "@angular/core";
import {AbstractService} from "./AbstcractService";
import {Product} from "../models/Product";
import {ProductRequest} from "../models/request/ProductRequest";

@Injectable({
  providedIn: 'root',
})
export class ProductService extends AbstractService<Product, ProductRequest>{
  constructor(http:HttpClient) {
    super(http,'http://localhost:8080/product');
  }
}
