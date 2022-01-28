package retro.server.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import retro.server.model.SessionResponse

@RestController
class SessionController {
    @GetMapping("/session")
    fun getSessions(meetingId: String): ResponseEntity<List<SessionResponse>> {
        return ResponseEntity.ok(listOf())
    }
}