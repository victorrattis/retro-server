package retro.server.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import retro.server.model.StickyResponse

@RestController
class StickyController {
    @GetMapping("/sticky")
    fun getStickies(sessionId: String): ResponseEntity<List<StickyResponse>> {
        return ResponseEntity.ok(listOf())
    }
}