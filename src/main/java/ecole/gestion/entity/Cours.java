package ecole.gestion.entity;

import lombok.Data;
import jakarta.persistence.*;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="Cours")
public class Cours {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id")
    private Long id;
    @Column(name="Titre")
    private String titre;
    @Column(name="Description")
    private String description;
    @Column(name="Duree")
    private int duree;
    @Column(name="Niveau")
    private String niveau;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "professeur_id", referencedColumnName="Id")
    private Professeur professeur;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "inscription_id", referencedColumnName="Id")
    private Inscription inscription;

}
