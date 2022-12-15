import { Injectable } from '@angular/core';

import * as Stomp from 'stompjs';
import * as SockJS from 'sockjs-client';
import {AppComponent} from "./app.component";
import {Message} from "./message";

const CHAT_URL = "http://localhost:20000/ws"

@Injectable({
  providedIn: 'root'
})
export class WebsocketService {
  webSocketEndPoint: string = CHAT_URL;
  topic: string = "/topic/public";
  stompClient: any;
  appComponent: AppComponent;

  constructor(appComponent: AppComponent) {
    this.appComponent = appComponent;
  }

  _connect() {
    console.log("Init WS Connection...");
    let ws = new SockJS(this.webSocketEndPoint);
    this.stompClient = Stomp.over(ws);
    const _this = this;

    _this.stompClient.connect({}, (frame: any) => {
      _this.stompClient.subscribe(_this.topic, (sdkEvent: any) => {
        _this.onMessageReceived(sdkEvent.body);
      });
    }, this.errorCallBack);
  }

  _disconnect() {
    if (this.stompClient !== null) {
      this.stompClient.disconnect();
    }
    console.log("Disconnected");
  }

  errorCallBack(error: any) {
    console.log("errorCallBack -> " + error);
    setTimeout(() => {
      this._connect();
    }, 5000);
  }

  _send(where: string, message: Message) {
    this.stompClient.send(where, { }, JSON.stringify(message));
  }

  onMessageReceived(message: any) {
    console.log("message received :: " + message);
    this.appComponent.handleMessage(JSON.parse(message));
  }
}
