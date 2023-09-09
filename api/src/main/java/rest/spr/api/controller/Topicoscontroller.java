package rest.spr.api.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rest.spr.api.topicos.DatosRegistroTopicos;

@RestController
@RequestMapping("/topicos")
public class Topicoscontroller {

    @PostMapping
    public void insertarTopico(@RequestBody DatosRegistroTopicos  datosRegistroTopicos){
        System.out.println(datosRegistroTopicos);

    }

}
