package ecole.gestion.dto;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProfesseurDTO {
    private Long id;
    private String nom;
    private String departement;
}
