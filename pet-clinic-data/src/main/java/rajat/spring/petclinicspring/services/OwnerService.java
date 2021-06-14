package rajat.spring.petclinicspring.services;

import rajat.spring.petclinicspring.model.Owner;

public interface OwnerService extends CrudService<Owner,Long>{

    Owner findByLastName(String lastName);
}
