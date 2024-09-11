package ecole.gestion.controller;

import ecole.gestion.dto.EtudiantDTO;
import ecole.gestion.entity.Etudiant;
import ecole.gestion.service.EtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@RestController
@RequestMapping("/api/etudiants")
public class EtudiantController {

    @Autowired
    private EtudiantService etudiantService;

    @GetMapping
    public List<EtudiantDTO> getAllEtudiants(@RequestParam int page, @RequestParam int size) {
        return etudiantService.getAllEtudiants(page, size);
    }

    @GetMapping("/{id}")
    public EtudiantDTO getEtudiantById(@PathVariable Long id) {
        return etudiantService.getEtudiantById(id);
    }

    @PostMapping
    public EtudiantDTO createEtudiant(@RequestBody EtudiantDTO etudiantDTO) {
        return etudiantService.createEtudiant(etudiantDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteEtudiant(@PathVariable Long id) {
        etudiantService.deleteEtudiant(id);
    }
}
