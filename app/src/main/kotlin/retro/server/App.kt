package retro.server

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import retro.server.repository.Meeting
import retro.server.repository.MemoryMeetingDataSource

@SpringBootApplication
open class PlantsApplication

fun main(args: Array<String>) {
	runApplication<PlantsApplication>(*args)
}

@RestController
class AppController {
    @GetMapping("/")
    fun getAll(): List<Meeting> {
        return  MemoryMeetingDataSource.meetingDataSource.getData()
    }
}
