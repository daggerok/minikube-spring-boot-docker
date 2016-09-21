package daggerok;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@SpringBootApplication
public class MinikubeSpringBootDockerApplication {

    @Value("${app.value}")
    String value;

    @GetMapping("/")
    String index(Model model) {

        model.addAttribute("value", value);
        return "index";
    }

    public static void main(String[] args) {
        SpringApplication.run(MinikubeSpringBootDockerApplication.class, args);
    }
}
