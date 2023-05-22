package cours.apprentissage.realtimeapplication.business.departement.mappers;

import cours.apprentissage.realtimeapplication.business.departement.Departement;
import cours.apprentissage.realtimeapplication.business.departement.dtos.DepartementDTO;
import cours.apprentissage.realtimeapplication.utils.EntityMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DepartementMapper extends EntityMapper<DepartementDTO, Departement> {
}
