package ecole.gestion.service;

import ecole.gestion.dto.EtudiantDTO;
import ecole.gestion.entity.Etudiant;
import ecole.gestion.repository.EtudiantRepository;
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
public class EtudiantService {

    @Autowired
    private EtudiantRepository etudiantRepository;

    public List<EtudiantDTO> getAllEtudiants(int page, int size) {
        Page<Etudiant> resultPage = etudiantRepository.findAll(PageRequest.of(page, size));
        return resultPage.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public EtudiantDTO getEtudiantById(Long id) {
        Etudiant etudiant = etudiantRepository.findById(id).orElseThrow();
        return convertToDTO(etudiant);
    }

    public EtudiantDTO createEtudiant(EtudiantDTO etudiantDTO) {
        Etudiant etudiant = convertToEntity(etudiantDTO);
        etudiant = etudiantRepository.save(etudiant);
        return convertToDTO(etudiant);
    }

    public void deleteEtudiant(Long id) {
        etudiantRepository.deleteById(id);
    }

    private EtudiantDTO convertToDTO(Etudiant etudiant) {
        EtudiantDTO dto = new EtudiantDTO();
        dto.setId(etudiant.getId());
        dto.setNom(etudiant.getNom());
        return dto;
    }

    private Etudiant convertToEntity(EtudiantDTO etudiantDTO) {
        Etudiant etudiant = new Etudiant();
        etudiant.setNom(etudiantDTO.getNom());
        return etudiant;
    }
}

