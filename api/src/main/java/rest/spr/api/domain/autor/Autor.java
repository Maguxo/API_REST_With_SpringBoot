package rest.spr.api.domain.autor;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Table(name = "autors")
@Entity(name = "Autor")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of= "id")
public class Autor implements UserDetails {

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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return contrasena;
    }

    @Override
    public String getUsername() {
        return nombre;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
