package ecole.gestion.dto;

import ecole.gestion.entity.Inscription;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class EtudiantDTO {
    private Long id;
    private String nom;
    private String addresse;
    private Inscription inscription;
}
