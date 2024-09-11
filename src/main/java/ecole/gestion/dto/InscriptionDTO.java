package ecole.gestion.dto;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;
import java.util.Date;
import java.util.List;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class InscriptionDTO {
    private Long id;
    private List<Long> coursIds;
    private Date dateInscription;
    private String status;
    private Long coursId;
    private Long etudiantId;
}
