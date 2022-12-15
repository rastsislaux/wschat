import { Component, Input, ChangeDetectionStrategy } from '@angular/core';
import {AuthInfo, Message} from "../message";
import {FormBuilder} from "@angular/forms";
import {WebsocketService} from "../websocket.service";

@Component({
  selector: 'app-message-list',
  templateUrl: './message-list.component.html',
  styleUrls: ['./message-list.component.css'],
  //changeDetection: ChangeDetectionStrategy.OnPush,
})

export class MessageListComponent {
  @Input() messages!: Message[]
  @Input() authInfo: AuthInfo = { isUnlogged: true, sender: "nobody" };
  @Input() wsService!: WebsocketService;
  formData: any;

  constructor(
    formBuilder: FormBuilder
  ) {
    this.formData = formBuilder.group({
      message: ''
    });
  }

  onSubmit() {
    let msg = this.formData.get("message")?.value;
    this.wsService._send("/app/chat.sendMessage", {
      id: undefined,
      content: msg,
      sender: this.authInfo.sender,
      type: "CHAT"
    });
  }

}

