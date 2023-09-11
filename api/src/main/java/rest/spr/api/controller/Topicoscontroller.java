package rest.spr.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rest.spr.api.topicos.Topico;
import rest.spr.api.topicos.DatosRegistroTopicos;
import rest.spr.api.topicos.TopicosRepository;

//@RestController
//@RequestMapping("/topicos")
public class Topicoscontroller {

    /*@Autowired// a nivel de testin no es recomendable
    //Se tendráproblemas al hacer pruebas unitarias
    private TopicosRepository topicosRepository;
    @PostMapping
    public void insertarTopico(@RequestBody DatosRegistroTopicos  datosRegistroTopicos){
        topicosRepository.save(new Topico(datosRegistroTopicos));
    }*/

}
