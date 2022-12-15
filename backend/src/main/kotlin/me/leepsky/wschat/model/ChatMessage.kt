package me.leepsky.wschat.model

import org.springframework.data.annotation.Id
import org.springframework.data.elasticsearch.annotations.Document

@Document(indexName = "messages")
open class ChatMessage(

    @Id
    open var id: String?,

    open var type: MessageType?,

    open var content: String?,

    open var sender: String?

) {
    enum class MessageType { CHAT, JOIN, LEAVE }

}