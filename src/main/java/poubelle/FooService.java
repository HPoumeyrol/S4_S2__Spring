package poubelle;

import java.util.List;
import java.util.Optional;


public interface FooService {

	public Foo save(Foo foo);
	
	public List<Foo> getAll();
	
	public Optional<Foo> findbyId(Long id);

}