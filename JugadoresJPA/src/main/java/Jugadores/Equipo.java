package Jugadores;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "equipo")
public class Equipo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "estadio", nullable = false, length = 100)
    private String estadio;

    @OneToMany(mappedBy = "idEquipo")
    private Set<Jugadores.Jugador> jugadors = new LinkedHashSet<>();

    public Equipo(String nombre, String estadio, Set<Jugador> jugadors) {
        this.nombre = nombre;
        this.estadio = estadio;
        this.jugadors = jugadors;
    }

    public Equipo() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstadio() {
        return estadio;
    }

    public void setEstadio(String estadio) {
        this.estadio = estadio;
    }

    public Set<Jugadores.Jugador> getJugadors() {
        return jugadors;
    }

    public void setJugadors(Set<Jugadores.Jugador> jugadors) {
        this.jugadors = jugadors;
    }

    @Override
    public String toString() {
        return "Equipo{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", estadio='" + estadio + '\'' +
                '}';
    }
}