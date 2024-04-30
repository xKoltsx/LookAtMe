import {HttpClient} from "@angular/common/http";

export abstract class AbstractService<T, Request> {
  constructor(private http: HttpClient, protected url: string) {
  }

  getAll() {
    return this.http.get<T[]>(this.url, {headers: this.getHeaders()});
  }

  get(id: number) {
    return this.http.get<T>(this.url + '/' + id,{headers: this.getHeaders()});
  }

  create(entity: Request) {
    return this.http.post(this.url, entity,{headers: this.getHeaders()});
  }

  update(entity: Request, id:number) {
    return this.http.put(this.url + '/' + id, JSON.stringify(entity),{headers: this.getHeaders()});
  }

  delete(id: number) {
    return this.http.delete(this.url + '/' + id,{headers: this.getHeaders()});
  }
  getHeaders(){
    return  { 'Content-Type': 'application/json', 'Accept': 'application/json' };
  }
}
