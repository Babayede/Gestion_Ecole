package ecole.gestion.entity;

import lombok.Data;
import jakarta.persistence.*;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.util.Date;
import lombok.Builder;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="Inscription")
public class Inscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id")
    private Long id;
    @Column(name="DateInscription")
    private Date dateInscription;
    @Column(name="Status")
    private String status;

    @OneToMany(mappedBy = "inscription", fetch=FetchType.LAZY)
    private List<Cours> cours;

    @OneToMany(mappedBy = "inscription", fetch=FetchType.LAZY)
    private List<Etudiant> etudiant;


}
