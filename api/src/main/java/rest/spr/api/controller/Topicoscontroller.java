package rest.spr.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import rest.spr.api.domain.topicos.*;

@RestController
@RequestMapping("/topicos")
public class Topicoscontroller {

    @Autowired// a nivel de testin no es recomendable
    //Se tendráproblemas al hacer pruebas unitarias
    private TopicosRepository topicosRepository;

    @PostMapping
    public void insertarTopico(@RequestBody @Valid DatosRegistroTopicos datosRegistroTopicos) {
        topicosRepository.save(new Topico(datosRegistroTopicos));
    }

    @GetMapping
    public Page<DatosListadoTopico> listadoTopico(@PageableDefault(size = 4) Pageable paginacion){ //para paginación muestra de datos.
        return  topicosRepository.findAll(paginacion).map(DatosListadoTopico::new);
    }//@PageableDefault(size = 2) me envia 2 datos solamente

    @PutMapping
    @Transactional
    public void actualizarTopico(@RequestBody @Valid DatosActualizarTopico datosActualizarTopico){
        Topico topico= topicosRepository.getReferenceById(datosActualizarTopico.id());
        topico.actualizarTopico(datosActualizarTopico);
    }
    @DeleteMapping("{id}")
    @Transactional
    public  void eliminaTopico(@PathVariable Long id){
        Topico topico= topicosRepository.getReferenceById(id);
        topicosRepository.delete(topico);
    }
}
/*@GetMapping
    public List<DatosListadoTopico> listadoTopico(){ Me muestra todos los datos y para un negocio es malo
        return topicosRepository.findAll().stream().map(DatosListadoTopico::new).toList();
    }*/

  //spring.jpa.show-sql=true /=esta linea me muestra en la consola las consultas que se hacen en MySQL.
  //spring.jpa.properties.hibernate.format_sql=true /= me muestra de forma ordenada la query de la base de datos.


