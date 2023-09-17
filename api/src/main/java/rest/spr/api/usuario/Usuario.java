package rest.spr.api.usuario;

import jakarta.persistence.*;
import lombok.*;

//@Embeddable
@Table(name = "usuarios")
@Entity(name = "Usuario")
@NoArgsConstructor //constructor sin atributos.
@AllArgsConstructor //constructor con todos los atributos.
@Getter //Construye los getters de las variables sin tener que escribir una por una,
@Setter //Construye todos los tters de las varibles sin tener que escribir una por una.
@EqualsAndHashCode(of= "id") // usa el parametro id para la comparaciones entre topicos
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String email;
    private String contrasena;

    public Usuario(DatosRegistroUsuario datosRegistroUsuario) {
        this.id= datosRegistroUsuario.id();
        this.nombre= datosRegistroUsuario.nombre();
        this.email= datosRegistroUsuario.email();
        this.contrasena= datosRegistroUsuario.contrasena();
    }
    public Usuario(Long autor_id) {
      this.id=autor_id;
    }

    public void actualizarUsuario(DatosActualizarUsuario datosActualizarUsuario) {
        if (datosActualizarUsuario.nombre() != null){
            this.nombre= datosActualizarUsuario.nombre();
        }if (datosActualizarUsuario.email() != null){
            this.email= datosActualizarUsuario.email();
        }if (datosActualizarUsuario.contrasena() != null){
            this.contrasena= datosActualizarUsuario.contrasena();
        }
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
        Usuario other = (Usuario) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }*/
}
