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
            .map(message -> {
                System.out.println(message);
                return message;
            })
            .count()
            .map(Controller::makeResponse)
            .doOnError(throwable -> System.err.println(throwable.getMessage()));
    }

    private static ResponseEntity<String> makeResponse(final Long count) {
        return ResponseEntity.ok("Counted " + count + " messages");
    }

}
