package ecole.gestion.dto;

import ecole.gestion.entity.Inscription;
import ecole.gestion.entity.Professeur;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CoursDTO {
    private Long id;
    private String titre;
    private String description;
    private int duree;
    private String niveau;
    private Professeur professeur;
    private Inscription inscription;
}
