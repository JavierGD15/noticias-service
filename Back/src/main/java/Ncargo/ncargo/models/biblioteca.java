package Ncargo.ncargo.models;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.Column;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Temporal;

@Getter
@Setter
@Entity
@Table(name = "libros", schema = "biblioteca")
public class biblioteca implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_libro")
    private int idlibro;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "id_autor")
    private Integer idAutor;

    @Column(name = "genero")
    private String genero;

    @Column(name = "editorial")
    private String editorial;

    @Column(name = "fecha_publicacion")
    
    @Temporal(jakarta.persistence.TemporalType.DATE)
    private Date fechaPublicacion;

    @Column(name = "cantidad_disponible")
    private Integer idDireccion;

}
