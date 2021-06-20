package rajat.spring.petclinicspring.services.map;

import org.springframework.stereotype.Service;
import rajat.spring.petclinicspring.model.Owner;
import rajat.spring.petclinicspring.model.Pet;
import rajat.spring.petclinicspring.services.OwnerService;
import rajat.spring.petclinicspring.services.PetService;
import rajat.spring.petclinicspring.services.PetTypeService;

import java.util.Set;

@Service
public class OwnerServiceMap extends AbstractMapService<Owner,Long> implements OwnerService {

    private final PetService petService;
    private final PetTypeService petTypeService;

    public OwnerServiceMap(PetService petService, PetTypeService petTypeService) {
        this.petService = petService;
        this.petTypeService = petTypeService;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public Owner save(Owner object) {
        if(object==null)
            return null;
        object.getPets().forEach(pet -> {
            if(pet.getPetType()==null)
                throw new RuntimeException("Pet type is required");
            if(pet.getPetType().getId()==null)
                pet.setPetType(petTypeService.save(pet.getPetType()));
            if(pet.getId() == null) {
                Pet savedPet = petService.save(pet);
                pet.setId(savedPet.getId());
            }
        });

        return super.save(object);
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }
}
