package ecole.gestion.controller;

import ecole.gestion.dto.ProfesseurDTO;
import ecole.gestion.entity.Professeur;
import ecole.gestion.service.ProfesseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.AllArgsConstructor;
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
@RequestMapping("/api/professeurs")
public class ProfesseurController {

    @Autowired
    private ProfesseurService professeurService;

    @GetMapping
    public List<ProfesseurDTO> getAllProfesseurs(@RequestParam int page, @RequestParam int size) {
        return professeurService.getAllProfesseurs(page, size);  // Correct method call with pagination parameters
    }

    @GetMapping("/{id}")
    public ProfesseurDTO getProfesseurById(@PathVariable Long id) {
        return professeurService.getProfesseurById(id);
    }

    @PostMapping
    public ProfesseurDTO createProfesseur(@RequestBody ProfesseurDTO professeurDTO) {
        return professeurService.createProfesseur(professeurDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteProfesseur(@PathVariable Long id) {
        professeurService.deleteProfesseur(id);
    }
}