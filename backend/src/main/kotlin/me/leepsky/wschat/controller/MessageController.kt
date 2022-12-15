package me.leepsky.wschat.controller

import me.leepsky.wschat.model.ChatMessage
import me.leepsky.wschat.service.MessageService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/messages")
class MessageController(
    private val messageService: MessageService
) {

    @PostMapping
    fun findByContentLike(@RequestBody content: String): Set<ChatMessage> {
        return messageService.findByContentLike(content);
    }

}