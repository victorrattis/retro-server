package retro.server.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import retro.server.model.CreateSessionDetail
import retro.server.model.SessionResponse
import retro.server.repository.MeetingRepository

@RestController
class SessionController {
    @Autowired
    lateinit var meetingRepository: MeetingRepository;

    @GetMapping("/session")
    fun getSessions(@RequestParam meetingId: String): ResponseEntity<List<SessionResponse>> {
        return ResponseEntity.ok(meetingRepository.getSessions(meetingId))
    }

    @PostMapping("/session")
    fun createSession(
        @RequestBody meetingId: String,
        @RequestBody session: CreateSessionDetail
    ): ResponseEntity<Boolean> {
        return ResponseEntity.ok(meetingRepository.createSession(meetingId, session))
    }
}