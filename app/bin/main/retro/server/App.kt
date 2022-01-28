package retro.server

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import retro.server.model.CreateColumnDetail
import retro.server.repository.InternalMeetingDataSource
import retro.server.repository.Meeting
import retro.server.repository.MeetingRepository
import retro.server.repository.MemoryMeetingDataSource
import java.text.SimpleDateFormat
import java.util.*


@SpringBootApplication
open class PlantsApplication

fun main(args: Array<String>) {
	runApplication<PlantsApplication>(*args)
}

@RestController
class AppController {
    @GetMapping("/")
    fun getPlants(): List<Meeting> {
        return  MemoryMeetingDataSource.meetingDataSource.getData()
    }
}
//
//    @GetMapping("/token")
//    fun token(@RequestParam token: String): Boolean {
//        try {
//            Jwts.parser().setSigningKey("my-secret").parseClaimsJws(token);
//            return true;
//        } catch (e: Exception) {
//            return false;
//        }
//    }
//
//    @GetMapping("/auth")
//    fun auth(): ResponseEntity<String> {
//        val secret: String = "my-secret"
//        val now = Date()
//
//        val token = Jwts.builder()
//            .setIssuer("IRS")
//            .setSubject("my-user")
//            .setIssuedAt(Date())
//            .setExpiration(Date(now.time + (1000 * 60 * 60)))
//            .signWith(SignatureAlgorithm.HS256, secret)
//            .compact()
//        return ResponseEntity.ok(token)
//    }
//}
//
//@EnableWebSecurity
//@Configuration
//open class SecurityConfiguration : WebSecurityConfigurerAdapter() {
//
//    @Autowired
//    lateinit var jwtRequestFilter: JwtRequestFilter
//
//    //Configurations for authentication
//    @Throws(Exception::class)
//    protected override fun configure(auth: AuthenticationManagerBuilder?) {
//
//    }
//
//    //Configuration for authorization
//    @Throws(Exception::class)
//    protected override fun configure(http: HttpSecurity?) {
//        if (http != null)
//        http.authorizeRequests()
//            .antMatchers(HttpMethod.GET, "/auth").permitAll()
//            .anyRequest().authenticated()
//            .and().csrf().disable()
//
//            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//
//        http?.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter::class.java)
//    }
//
//    //Configuration for static resources
//    @Throws(Exception::class)
//    override fun configure(web: WebSecurity?) {
//    }
//}
//
//@Component
//class JwtRequestFilter : OncePerRequestFilter() {
//    override fun doFilterInternal(
//        request: HttpServletRequest,
//        response: HttpServletResponse,
//        filterChain: FilterChain
//    ) {
//        println("doFilterInternal")
//        val requestTokenHeader = request.getHeader("Authorization");
//        var jwtToken: String? = null
//        if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
//            jwtToken = requestTokenHeader.substring(7)
//        }
//
//        val result = isTokenValid(jwtToken)
//
//        println("jwtToken: $jwtToken == $result")
//        if (result) {
////            SecurityContextHolder.getContext().authentication = UsernamePasswordAuthenticationToken(
////                "username",
////                "passwork"
////            )
//
//            val userDetails = User(
//                "javainuse",
//                "$2a\$10\$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6", ArrayList());
//            val usernamePasswordAuthenticationToken = UsernamePasswordAuthenticationToken(
//                userDetails, null, userDetails.getAuthorities()
//            )
//            usernamePasswordAuthenticationToken.details = WebAuthenticationDetailsSource().buildDetails(request)
//            // After setting the Authentication in the context, we specify
//            // that the current user is authenticated. So it passes the
//            // Spring Security Configurations successfully.
//            // After setting the Authentication in the context, we specify
//            // that the current user is authenticated. So it passes the
//            // Spring Security Configurations successfully.
//            SecurityContextHolder.getContext().authentication = usernamePasswordAuthenticationToken
//        }
//
//        filterChain.doFilter(request, response);
//    }
//}
//
//
//private fun isTokenValid(token: String?): Boolean = try {
//    Jwts.parser().setSigningKey("my-secret").parseClaimsJws(token);
//    true;
//} catch (e: Exception) {
//    false;
//}
