package Ncargo.ncargo.models;
import java.io.Serializable;
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "noticias", schema = "infiel_prueba")
public class noticiasModel implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_noticias;

    private String titulo;
    
    @ManyToOne
    @JoinColumn(name = "id_clasificacion", nullable = false)
    private clasificacionModel clasificacion;

    private String descripcion;

    @Temporal(TemporalType.DATE)
    private Date fecha_creacion;

    @Column(columnDefinition = "TEXT")
    private String texto;

    private String enlace_photo;

}
