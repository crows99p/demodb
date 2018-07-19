package jp.co.demo.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/alive")
public class AliveController {

    @RequestMapping(method = RequestMethod.GET)
    public String getAlive() {
        String msg = "We are alive.";
        return msg;
    }

}
