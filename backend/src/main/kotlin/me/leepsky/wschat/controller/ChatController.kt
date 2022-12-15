package me.leepsky.wschat.controller

import me.leepsky.wschat.model.ChatMessage
import me.leepsky.wschat.service.MessageService
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.messaging.simp.SimpMessageHeaderAccessor
import org.springframework.stereotype.Controller

@Controller
class ChatController(
    private val messageService: MessageService
) {

    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    fun sendMessage(@Payload chatMessage: ChatMessage): ChatMessage {
        return messageService.create(chatMessage)
    }

    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    fun addUser(@Payload chatMessage: ChatMessage,
                headerAccessor: SimpMessageHeaderAccessor): ChatMessage {
        headerAccessor.sessionAttributes?.set("username", chatMessage.sender)
        return chatMessage
    }

}