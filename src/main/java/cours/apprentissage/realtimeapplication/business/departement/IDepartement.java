package cours.apprentissage.realtimeapplication.business.departement;

import cours.apprentissage.realtimeapplication.business.departement.dtos.DepartementDTO;

import java.util.List;

public interface IDepartement {
    DepartementDTO save(DepartementDTO departementDTO);

    List<DepartementDTO> getAllDepartement();
    Boolean delete(Long id);

    DepartementDTO update(DepartementDTO departementDTO);
}
