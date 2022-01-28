package retro.server.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import retro.server.model.CreateStickyDetail
import retro.server.model.StickyResponse
import retro.server.repository.MeetingRepository

@RestController
class StickyController {
    @Autowired
    lateinit var meetingRepository: MeetingRepository

    @GetMapping("/sticky")
    fun getStickies(
        @RequestParam meetingId: String,
        @RequestParam sessionId: String
    ): ResponseEntity<List<StickyResponse>> {
        return ResponseEntity.ok(meetingRepository.getStickies(meetingId, sessionId))
    }

    @PostMapping("/sticky")
    fun createSticky(
        @RequestBody createStickyDetail: CreateStickyDetail
    ): ResponseEntity<Boolean> {
        return ResponseEntity.ok(meetingRepository.createSticky(createStickyDetail))
    }
}