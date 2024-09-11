package ecole.gestion.service;

import ecole.gestion.dto.ProfesseurDTO;
import ecole.gestion.entity.Professeur;
import ecole.gestion.repository.ProfesseurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Service
public class ProfesseurService {

    @Autowired
    private ProfesseurRepository professeurRepository;

    public List<ProfesseurDTO> getAllProfesseurs(int page, int size) {
        Page<Professeur> resultPage = professeurRepository.findAll(PageRequest.of(page, size));
        return resultPage.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public ProfesseurDTO getProfesseurById(Long id) {
        Professeur professeur = professeurRepository.findById(id).orElseThrow();
        return convertToDTO(professeur);
    }

    public ProfesseurDTO createProfesseur(ProfesseurDTO professeurDTO) {
        Professeur professeur = convertToEntity(professeurDTO);
        professeur = professeurRepository.save(professeur);
        return convertToDTO(professeur);
    }

    public void deleteProfesseur(Long id) {
        professeurRepository.deleteById(id);
    }

    private ProfesseurDTO convertToDTO(Professeur professeur) {
        ProfesseurDTO dto = new ProfesseurDTO();
        dto.setId(professeur.getId());
        dto.setNom(professeur.getNom());

        return dto;
    }

    private Professeur convertToEntity(ProfesseurDTO professeurDTO) {
        Professeur professeur = new Professeur();
        professeur.setNom(professeurDTO.getNom());
        return professeur;
    }
}
