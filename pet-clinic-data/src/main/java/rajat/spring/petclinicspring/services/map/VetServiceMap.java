package rajat.spring.petclinicspring.services.map;

import org.springframework.stereotype.Service;
import rajat.spring.petclinicspring.model.Speciality;
import rajat.spring.petclinicspring.model.Vet;
import rajat.spring.petclinicspring.services.SpecialtiesService;
import rajat.spring.petclinicspring.services.VetService;

import java.util.Set;

@Service
public class VetServiceMap extends AbstractMapService<Vet,Long> implements VetService {
    private final SpecialtiesService specialtiesService;

    public VetServiceMap(SpecialtiesService specialtiesService) {
        this.specialtiesService = specialtiesService;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public Vet save(Vet object) {
        if(object == null) return null;
        if(!object.getSpecialities().isEmpty()){
            object.getSpecialities().forEach(speciality -> {
                if(speciality.getId() == null){
                    Speciality savedSpecialty=specialtiesService.save(speciality);
                    speciality.setId(savedSpecialty.getId());
                }
            });
        }
        return super.save(object);
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }
}
