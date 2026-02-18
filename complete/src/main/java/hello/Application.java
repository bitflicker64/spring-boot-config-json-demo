package hello;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application {

    @Value("${app.message:default}")
    private String message;

    @GetMapping("/")
    public String home() {
        return "Message = " + message;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
