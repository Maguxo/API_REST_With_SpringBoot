package rest.spr.api.respuesta;

import jakarta.persistence.*;
import lombok.*;
import rest.spr.api.usuario.Usuario;
import rest.spr.api.topicos.Topico;

import java.time.LocalDateTime;
//@Embeddable
@Table(name = "respuestas") //nombre de la tabla en mysql
@Entity(name = "Respuesta")
@NoArgsConstructor //constructor sin atributos.
@AllArgsConstructor //constructor con todos los atributos.
@Getter //Construye los getters de las variables sin tener que escribir una por una,
@Setter //Construye todos los tters de las varibles sin tener que escribir una por una.
@EqualsAndHashCode(of= "id") // usa el parametro id para la comparaciones entre topicos
public class Respuesta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mensaje;
    //@ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "topico_id")
    //private Topico topico;
    private LocalDateTime fecha;
    //@ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "usuario_id")
    //private Usuario usuario;
    private Boolean solucion;

    public Respuesta(DatosRegistroRespuesta datosRegistroRespuesta) {
        this.id= datosRegistroRespuesta.id();
        this.mensaje= datosRegistroRespuesta.mensaje();
        this.fecha= datosRegistroRespuesta.fecha();
        this.solucion= datosRegistroRespuesta.solucion();
    }
    /*@Override
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
        Respuesta other = (Respuesta) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }*/
}
