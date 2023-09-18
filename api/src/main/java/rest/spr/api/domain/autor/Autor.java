package rest.spr.api.domain.autor;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "autors")
@Entity(name = "Autor")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of= "id")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String email;
    private String contrasena;
    public Autor(DatosRegistroAutor datosRegistroAutor) {
        this.id= datosRegistroAutor.id();
        this.nombre= datosRegistroAutor.nombre();
        this.email= datosRegistroAutor.email();
        this.contrasena= datosRegistroAutor.contrasena();
    }

    public Autor(Long id) {
      this.id=id;
    }

    public void actualizarAutor(DatosActualizarAutor datosActualizarAutor) {
        if (datosActualizarAutor.nombre() != null){
            this.nombre= datosActualizarAutor.nombre();
        }if (datosActualizarAutor.email() != null){
            this.email= datosActualizarAutor.email();
        }if (datosActualizarAutor.contrasena() != null){
            this.contrasena= datosActualizarAutor.contrasena();
        }
    }
}
