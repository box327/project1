package test.test.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends CrudRepository<UserData, Long>{
	public UserData findByUserId(String userId);
}
