import { Component } from '@angular/core';
import {AuthInfo, Message} from "./message";
import {WebsocketService} from "./websocket.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent {
  title = 'wschatfe';
  messages: Message[] = [];
  wsService!: WebsocketService;
  authInfo: AuthInfo = { isUnlogged: true, sender: "nobody" };

  ngOnInit() {
    this.wsService = new WebsocketService(this);
    this.wsService._connect();
  }

  handleMessage(message: any) {
    let msg = message as Message;
    console.table(msg);
    this.messages.push(msg);
  }
}
