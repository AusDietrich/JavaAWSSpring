package personal.JavaAWS.repo;

import java.util.Iterator;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import personal.JavaAWS.entity.ColorsEntity;
import personal.JavaAWS.entity.User;

@Repository
public interface ColorsRepo extends CrudRepository<ColorsEntity, Long>{
	@Query(value="Select * from Colors", nativeQuery=true)
	Iterator<ColorsEntity> findColors();
	
	@Query(value="Insert Into Colors (title, colorimg, price, description)"+
				"Value(:title, :colorimg, :price, :description)", nativeQuery=true)
	void insertColor(@Param("title") String title, @Param("colorimg") String colorImg,
			@Param("price") Double price, @Param("description") String description);
}
