package rest.spr.api.topicos;
import jakarta.persistence.*;
import lombok.*;
import rest.spr.api.curso.Curso;
import rest.spr.api.curso.CursoRepository;
import rest.spr.api.respuesta.Respuesta;
import rest.spr.api.usuario.Usuario;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Table(name = "topicos") //nombre de la tabla en mysql
@Entity(name = "Topico")
@NoArgsConstructor //constructor sin atributos.
@AllArgsConstructor //constructor con todos los atributos.
@Getter //Construye los getters de las variables sin tener que escribir una por una,
@Setter //Construye todos los tters de las varibles sin tener que escribir una por una.
@EqualsAndHashCode(of= "id") // usa el parametro id para la comparaciones entre topicos
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    private LocalDateTime fechaCreacion = LocalDateTime.now();
    @Enumerated(EnumType.STRING)
    private StatusTopico status = StatusTopico.NO_RESPONDIDO;
    @Embedded //es para instanciar la clase de lo contrario tendria que hacer Usuario autor= new Usuario();
    private Usuario autor;
    @Embedded  //es para instanciar la clase
    private Curso curso;
    @Embedded //es para instanciar la clase
    private Respuesta respuesta;
    //private List<Respuesta> respuestas = new ArrayList<>();
    public Topico(DatosRegistroTopicos datosRegistroTopicos) {

      this.titulo= datosRegistroTopicos.titulo();
      this.mensaje= datosRegistroTopicos.mensaje();
      this.fechaCreacion= LocalDateTime.parse(datosRegistroTopicos.fechaCreacion());
      this.status= datosRegistroTopicos.estatusTopico();
      this.autor= new Usuario(datosRegistroTopicos.autor());
      //this.curso= new Curso(datosRegistroTopicos.curso());
      this.respuesta= new Respuesta(datosRegistroTopicos.respuesta());
    }
   /* @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Topico other = (Topico) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
    public List<Respuesta> getRespuestas() {
        return respuestas;
    }
    public void setRespuestas(List<Respuesta> respuestas) {
        this.respuestas = respuestas;
    }*/

}
