package me.leepsky.wschat.websocket

import me.leepsky.wschat.model.ChatMessage
import mu.KotlinLogging
import org.springframework.context.event.EventListener
import org.springframework.messaging.simp.SimpMessagingTemplate
import org.springframework.messaging.simp.stomp.StompHeaderAccessor
import org.springframework.stereotype.Component
import org.springframework.web.socket.messaging.SessionConnectedEvent
import org.springframework.web.socket.messaging.SessionDisconnectEvent

@Component
class WebSocketEventListener(
    val messagingTemplate: SimpMessagingTemplate
) {

    companion object {
        private val log = KotlinLogging.logger { }
    }

    @EventListener
    fun handleWebSocketConnectListener(event: SessionConnectedEvent) {
        log.info { "Received a new websocket connection: $event" }
    }

    @EventListener
    fun handleWebSocketDisconnectListener(event: SessionDisconnectEvent) {
        val headerAccessor = StompHeaderAccessor.wrap(event.message)
        val username = headerAccessor.sessionAttributes?.get("username") as String
        username.let {
            log.info { "User disconnected: $username" }

            val chatMessage = ChatMessage(
                id = null,
                type = ChatMessage.MessageType.LEAVE,
                sender = username,
                content = ""
            )

            messagingTemplate.convertAndSend(chatMessage)
        }
    }

}