package by.tms.lesson5833onl.controller;

import by.tms.lesson5833onl.entity.Greeting;
import by.tms.lesson5833onl.repository.GreetingHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    @Autowired
    private GreetingHistoryRepository greetingHistoryRepository;

    @GetMapping
    public ResponseEntity<GreetingResponse> greeting(@RequestParam("name") String name) {
        String result = "Hello %s!".formatted(name);

        greetingHistoryRepository.save(new Greeting().setMessage(result));

        return ResponseEntity.ok(new GreetingResponse(result));
    }

    @GetMapping("/history")
    public ResponseEntity<Iterable<Greeting>> history() {
        return ResponseEntity.ok(greetingHistoryRepository.findAll());
    }

    public record GreetingResponse(String message) {}

}
