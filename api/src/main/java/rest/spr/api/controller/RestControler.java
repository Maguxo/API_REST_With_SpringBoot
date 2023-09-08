package rest.spr.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Magucho")
public class RestControler {

    @GetMapping
    public String prueba(){
        return "esto es una prueba Magucho";
    }
}
