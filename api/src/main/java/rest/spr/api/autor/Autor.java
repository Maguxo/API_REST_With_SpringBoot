package rest.spr.api.autor;

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
}
