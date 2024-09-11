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
@Table(name="Etudiant")
public class Etudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id")
    private Long id;
    @Column(name="Nom")
    private String nom;
    @Column(name="Email")
    private String email;
    @Column(name="Addresse")
    private String addresse;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "inscription_id", referencedColumnName="Id")
    private Inscription inscription;
}
