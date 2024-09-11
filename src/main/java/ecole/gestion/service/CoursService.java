package ecole.gestion.service;

import ecole.gestion.dto.CoursDTO;
import ecole.gestion.entity.Cours;
import ecole.gestion.repository.CoursRepository;
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
public class CoursService {

    @Autowired
    private CoursRepository coursRepository;

    public List<CoursDTO> getAllCours(int page, int size) {
        Page<Cours> resultPage = coursRepository.findAll(PageRequest.of(page, size));
        return resultPage.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public CoursDTO getCoursById(Long id) {
        Cours cours = coursRepository.findById(id).orElseThrow();
        return convertToDTO(cours);
    }

    public CoursDTO createCours(CoursDTO coursDTO) {
        Cours cours = convertToEntity(coursDTO);
        cours = coursRepository.save(cours);
        return convertToDTO(cours);
    }

    public void deleteCours(Long id) {
        coursRepository.deleteById(id);
    }

    private CoursDTO convertToDTO(Cours cours) {
        CoursDTO dto = new CoursDTO();
        dto.setId(cours.getId());
        dto.setTitre(cours.getTitre());
        return dto;
    }

    private Cours convertToEntity(CoursDTO coursDTO) {
        Cours cours = new Cours();
        cours.setTitre(coursDTO.getTitre());
        return cours;
    }
}