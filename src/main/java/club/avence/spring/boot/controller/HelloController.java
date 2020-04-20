package club.avence.spring.boot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 欢迎信息
 *
 * @author qian3
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(String name) {
        return "Hello! Here is Spring Boot!";
    }

}
