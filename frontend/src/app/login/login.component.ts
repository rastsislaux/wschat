import {Component, EventEmitter, Input, Output} from '@angular/core';
import { FormBuilder } from "@angular/forms";
import {WebsocketService} from "../websocket.service";
import {AuthInfo} from "../message";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  @Input() authInfo: AuthInfo = { isUnlogged: true, sender: "nobody" };
  @Input() wsService!: WebsocketService;
  private formBuilder = new FormBuilder();
  formData = this.formBuilder.group({
    name: ''
  });

  onSubmit() {
    this.authInfo.isUnlogged = false;
    this.authInfo.sender = this.formData.get("name")?.value ?? "nobody";
    this.wsService._send("/app/chat.addUser", {
      content: undefined,
      id: undefined,
      sender: this.authInfo.sender,
      type: "JOIN"
    });
  }
}
