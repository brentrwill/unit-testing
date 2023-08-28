package pet.store.controller;

import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestContoller {
    @GetMapping(value = "/test")
    public String getTestData(@RequestParam(name = "str") String data) {
        StringBuilder builder = new StringBuilder();
        Date date = new Date();
        builder.append("Server Received the following string \"" + data + "\" at " + date.toString());

        return builder.toString();
    }
}
