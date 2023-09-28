package rest.spr.api.controller;
/**CREATED BY Edgar M Gómez P
 * Backend Developer*/
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Magucho")
public class HelloController {

    @GetMapping
    public String helloWorld(){
        return "¡hola, Magucho!";
    }
}
