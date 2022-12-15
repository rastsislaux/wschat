package me.leepsky.wschat.service

import me.leepsky.wschat.model.ChatMessage
import me.leepsky.wschat.repository.MessageRepository
import org.springframework.stereotype.Service

@Service
class MessageService(
    private val messageRepository: MessageRepository
) {

    fun create(chatMessage: ChatMessage): ChatMessage {
        return messageRepository.save(chatMessage)
    }

    fun findByContentLike(content: String): Set<ChatMessage> {
        return messageRepository.findAllByContent(content)
    }

}