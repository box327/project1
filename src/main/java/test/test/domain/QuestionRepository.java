package test.test.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends CrudRepository<QuestionData, Long>{

}
