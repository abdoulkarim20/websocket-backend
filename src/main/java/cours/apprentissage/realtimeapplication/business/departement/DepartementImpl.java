package cours.apprentissage.realtimeapplication.business.departement;

import cours.apprentissage.realtimeapplication.business.departement.dtos.DepartementDTO;
import cours.apprentissage.realtimeapplication.business.departement.mappers.DepartementMapper;
import cours.apprentissage.realtimeapplication.business.webSocket.IWebSocketService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DepartementImpl implements IDepartement {
    private final DepartementRepository departementRepository;
    private final DepartementMapper departementMapper;
    private final IWebSocketService iWebSocketService;
    public DepartementImpl(DepartementRepository departementRepository, DepartementMapper departementMapper, IWebSocketService iWebSocketService) {
        this.departementRepository = departementRepository;
        this.departementMapper = departementMapper;
        this.iWebSocketService = iWebSocketService;
    }

    @Override
    public DepartementDTO save(DepartementDTO departementDTO) {
        Departement departement = departementRepository.save(departementMapper.toEntity(departementDTO));
        notifyFrontend();
        return departementMapper.toDto(departement);
    }

    @Override
    public List<DepartementDTO> getAllDepartement() {
        List<Departement>list=departementRepository.findAll();
        return departementMapper.toDto(list);
    }

    @Override
    public Boolean delete(Long id) {
        Departement departement=departementRepository.findById(id).get();
        if (departement.getId()==null){
            System.out.println("Ce departement n'existe pas");
        }
        departementRepository.deleteById(id);
        notifyFrontend();
        return true;
    }

    @Override
    public DepartementDTO update(DepartementDTO departementDTO) {
        Departement departement=departementMapper.toEntity(departementDTO);
        if (departement.getId()==null){
            System.out.println("Ce departement n'existe pas");
        }
        Departement departementUpdated=departementRepository.save(departement);
        notifyFrontend();
        return departementMapper.toDto(departementUpdated);
    }


    private void notifyFrontend() {
        final String entityTopic = "departements";
        if (entityTopic == null) {
            System.out.println("Failed to get entity topic");
        }
        /*iWebSocketService.sendMessage(entityTopic);*/
        iWebSocketService.sendMessage(entityTopic,"Notification from message departement services");
    }
}
