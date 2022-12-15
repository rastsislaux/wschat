import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Message} from "./message";

@Injectable({
  providedIn: 'root'
})
export class RestService {
  private httpClient: HttpClient;

  constructor(
    httpClient: HttpClient
  ) {
    this.httpClient = httpClient;
  }

  fulltextSearch(query: String) {
    console.log("Queried: " + query);
    return this.httpClient.post<Message[]>("http://localhost:20000/api/v1/messages", query);
  }

}
