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
@Table(name="Professeur")
public class Professeur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id")
    private Long id;
    @Column(name="Nom")
    private String nom;
    @Column(name="Email")
    private String email;
    @Column(name="Departement")
    private String departement;

    @OneToMany(mappedBy = "professeur", fetch=FetchType.LAZY)
    private List<Cours> cours;
}
