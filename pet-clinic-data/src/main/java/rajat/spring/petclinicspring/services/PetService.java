package rajat.spring.petclinicspring.services;

import rajat.spring.petclinicspring.model.Pet;

import java.util.Set;

public interface PetService {

    Pet findById(Long id);

    Pet save(Pet pet);

    Set<Pet> findAll();
}
