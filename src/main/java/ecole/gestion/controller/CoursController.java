package ecole.gestion.controller;

import ecole.gestion.dto.CoursDTO;
import ecole.gestion.entity.Cours;
import ecole.gestion.entity.Professeur;
import ecole.gestion.service.CoursService;
import ecole.gestion.service.ProfesseurService;
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
@RequestMapping("/api/cours")
public class CoursController {

    @Autowired
    private CoursService coursService;

    @GetMapping
    public List<CoursDTO> getAllCours(@RequestParam int page, @RequestParam int size) {
        return coursService.getAllCours(page, size); // Correct method call with pagination parameters
    }

    @GetMapping("/{id}")
    public CoursDTO getCoursById(@PathVariable Long id) {
        return coursService.getCoursById(id);
    }

    @PostMapping
    public CoursDTO createCours(@RequestBody CoursDTO coursDTO) {
        return coursService.createCours(coursDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteCours(@PathVariable Long id) {
        coursService.deleteCours(id);
    }
}

