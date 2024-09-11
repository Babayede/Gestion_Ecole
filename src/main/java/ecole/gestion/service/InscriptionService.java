package ecole.gestion.service;

import ecole.gestion.dto.InscriptionDTO;
import ecole.gestion.entity.Inscription;
import ecole.gestion.entity.Cours;
import ecole.gestion.entity.Etudiant;
import ecole.gestion.repository.InscriptionRepository;
import ecole.gestion.repository.CoursRepository;
import ecole.gestion.repository.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class InscriptionService {

    @Autowired
    private InscriptionRepository inscriptionRepository;

    @Autowired
    private CoursRepository coursRepository;

    @Autowired
    private EtudiantRepository etudiantRepository;

    // Create or Update Inscription
    @Transactional
    public InscriptionDTO createOrUpdateInscription(InscriptionDTO inscriptionDTO) {
        Inscription inscription = Inscription.builder()
                .id(inscriptionDTO.getId())
                .dateInscription(inscriptionDTO.getDateInscription())
                .status(inscriptionDTO.getStatus())
                .build();

        // Set Cours and Etudiant
        Optional<Cours> coursOptional = coursRepository.findById(inscriptionDTO.getCoursId());
        Optional<Etudiant> etudiantOptional = etudiantRepository.findById(inscriptionDTO.getEtudiantId());

        if (coursOptional.isPresent()) {
            inscription.setCours(List.of(coursOptional.get()));
        }

        if (etudiantOptional.isPresent()) {
            inscription.setEtudiant(List.of(etudiantOptional.get()));
        }

        Inscription savedInscription = inscriptionRepository.save(inscription);
        return mapToDTO(savedInscription);
    }

    // Get Inscription by ID
    @Transactional
    public InscriptionDTO getInscriptionById(Long id) {
        Optional<Inscription> inscriptionOptional = inscriptionRepository.findById(id);
        if (inscriptionOptional.isPresent()) {
            return mapToDTO(inscriptionOptional.get());
        }
        return null; // Handle error appropriately
    }

    // Delete Inscription by ID
    @Transactional
    public void deleteInscription(Long id) {
        inscriptionRepository.deleteById(id);
    }

    // Get all Inscriptions with manual pagination
    @Transactional
    public List<InscriptionDTO> getAllInscriptions(int page, int size) {
        List<Inscription> inscriptions = inscriptionRepository.findAll();
        return inscriptions.stream()
                .skip((long) (page - 1) * size)
                .limit(size)
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    // Helper method to map entity to DTO
    @Transactional
    private InscriptionDTO mapToDTO(Inscription inscription) {
        List<Long> coursIds = inscription.getCours() != null ?
                inscription.getCours().stream().map(Cours::getId).collect(Collectors.toList()) : null;

        Long etudiantId = inscription.getEtudiant() != null && !inscription.getEtudiant().isEmpty() ?
                inscription.getEtudiant().get(0).getId() : null;

        return InscriptionDTO.builder()
                .id(inscription.getId())
                .dateInscription(inscription.getDateInscription())
                .status(inscription.getStatus())
                .coursIds(coursIds)
                .etudiantId(etudiantId)
                .build();
    }
}
