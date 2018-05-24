package poubelle;

import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.inject.Named;

import co.simplon.crud.model.Foo;
import co.simplon.crud.repository.FooRepository;

@Named
public class FooServiceImpl implements FooService {

    @Inject
    FooRepository fooRepository;
	
    public Foo saveFoo(Foo foo) {
	  fooRepository.save(foo);
	  return foo;
    }

    public List<Foo> getAll() {
	  return fooRepository.findAll();  // TODO
    }
    
    public Optional<Foo> findbyId(Long id) {
		
	  return fooRepository.findById(id);
    }

}