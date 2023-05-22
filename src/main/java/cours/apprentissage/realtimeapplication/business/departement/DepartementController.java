package cours.apprentissage.realtimeapplication.business.departement;

import cours.apprentissage.realtimeapplication.business.departement.dtos.DepartementDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/departements")
public class DepartementController {
    private final IDepartement iDepartement;
    public DepartementController(IDepartement iDepartement) {
        this.iDepartement = iDepartement;
    }
    @PostMapping("")
    public DepartementDTO save(@RequestBody DepartementDTO departementDTO){
        return iDepartement.save(departementDTO);
    }
    @GetMapping("")
    public List<DepartementDTO>getAllDepartement(){
        return iDepartement.getAllDepartement();
    }
    @DeleteMapping("")
    public Boolean deleteDepartement(@RequestParam Long id){
        iDepartement.delete(id);
        return true;
    }
    @PutMapping("")
    public DepartementDTO update(@RequestParam Long id, @RequestBody DepartementDTO departementDTO){
        departementDTO.setId(id);
        return iDepartement.update(departementDTO);
    }
}
