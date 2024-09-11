package ecole.gestion.controller;

import ecole.gestion.dto.InscriptionDTO;
import ecole.gestion.service.InscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inscriptions")
public class InscriptionController {

    @Autowired
    private InscriptionService inscriptionService;

    // Create or update an inscription
    @PostMapping
    public InscriptionDTO createOrUpdateInscription(@RequestBody InscriptionDTO inscriptionDTO) {
        return inscriptionService.createOrUpdateInscription(inscriptionDTO);
    }

    // Get an inscription by ID
    @GetMapping("/{id}")
    public InscriptionDTO getInscriptionById(@PathVariable Long id) {
        return inscriptionService.getInscriptionById(id);
    }

    // Delete an inscription by ID
    @DeleteMapping("/{id}")
    public void deleteInscription(@PathVariable Long id) {
        inscriptionService.deleteInscription(id);
    }

    // Get all inscriptions with pagination
    @GetMapping
    public List<InscriptionDTO> getAllInscriptions(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size) {
        return inscriptionService.getAllInscriptions(page, size);
    }
}
