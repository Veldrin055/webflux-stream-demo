package morrison.stream;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author Daniel Morrison
 * @since 20/11/2018.
 */
@RestController
@RequestMapping("/")
public class Controller {

    @PostMapping(consumes = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Mono<ResponseEntity<String>> update(@RequestBody Flux<Message> messages) {
        return messages
            .map(Controller::logMessage)
            .count()
            .map(aLong -> ResponseEntity.ok("Counted " + aLong + " messages"))
            .doOnError(throwable -> System.err.println(throwable.getMessage()));

    }

    static Message logMessage(Message message) {
        System.out.println("{ id: " + message.getId() + ", message:" + message.getMessage() + " }");
        return message;
    }
}
