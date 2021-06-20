package rajat.spring.petclinicspring.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import rajat.spring.petclinicspring.model.Owner;
import rajat.spring.petclinicspring.model.PetType;
import rajat.spring.petclinicspring.model.Vet;
import rajat.spring.petclinicspring.services.OwnerService;
import rajat.spring.petclinicspring.services.PetTypeService;
import rajat.spring.petclinicspring.services.VetService;
import rajat.spring.petclinicspring.services.map.OwnerServiceMap;
import rajat.spring.petclinicspring.services.map.VetServiceMap;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }


    @Override
    public void run(String... args) throws Exception {

        System.out.println("Inside dataloader");

        PetType dog = new PetType();
        dog.setName("Max");
        petTypeService.save(dog);
        System.out.println("saved dog with id: "+dog.getId());

        PetType cat = new PetType();
        cat.setName("Mini");
        petTypeService.save(cat);
        System.out.println("saved cat with id: "+cat.getId());

        System.out.println("Creating owners");

        Owner owner1 = new Owner();
        owner1.setFirstName("Rajat");
        owner1.setLastName("Patel");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Shreya");
        owner2.setLastName("Patel");
        ownerService.save(owner2);

        System.out.println("Creating Vets");

        Vet vet1 = new Vet();
        vet1.setFirstName("Rajan");
        vet1.setLastName("Patel");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Shraddha");
        vet2.setLastName("Patel");
        vetService.save(vet2);

        System.out.println("Done....");
    }
}
