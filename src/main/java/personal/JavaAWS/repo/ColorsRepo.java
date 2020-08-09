package personal.JavaAWS.repo;

import java.util.Iterator;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import personal.JavaAWS.entity.ColorsEntity;
import personal.JavaAWS.entity.User;

@Repository
public interface ColorsRepo extends CrudRepository<ColorsEntity, Long>{
	@Query(value="Select * from Colors", nativeQuery=true)
	Iterator<ColorsEntity> findColors();
}
