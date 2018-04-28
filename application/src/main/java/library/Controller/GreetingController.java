package library.Controller;

import java.util.concurrent.atomic.AtomicLong;


import library.Greeting;
import library.service.GreetingService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private final GreetingService greetingService;
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    public GreetingController(GreetingService greetingService){
        this.greetingService = greetingService;
    }

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        greetingService.setMessage(name);
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name + ", " + greetingService.getMessage()));
    }
}