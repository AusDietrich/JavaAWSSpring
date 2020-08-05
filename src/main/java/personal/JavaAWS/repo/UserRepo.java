package personal.JavaAWS.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import personal.JavaAWS.entity.User;

@Repository
public interface UserRepo extends CrudRepository <User, Long>{

	@Query(value="Select * from User", nativeQuery=true)
	User findUsers();
}
