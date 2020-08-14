package personal.JavaAWS.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import personal.JavaAWS.entity.ColorsEntity;

@Repository
public interface ColorsRepo extends CrudRepository<ColorsEntity, Integer>{
	
}
