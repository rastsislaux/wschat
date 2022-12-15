package me.leepsky.wschat.repository

import me.leepsky.wschat.model.ChatMessage
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository

interface MessageRepository : ElasticsearchRepository<ChatMessage, String> {

    fun findAllByContentLikeIgnoreCase(content: String): Set<ChatMessage>

    fun findAllByContent(content: String): Set<ChatMessage>

}