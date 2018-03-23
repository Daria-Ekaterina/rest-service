package old;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();


    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="world!") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }

//    @RequestMapping("/greeting")
//    public Calculator greeting(@RequestParam(value="arg1") int arg1, @RequestParam(value="arg2") int arg2) {
//        return new Calculator(arg1,arg2);
//    }


}
