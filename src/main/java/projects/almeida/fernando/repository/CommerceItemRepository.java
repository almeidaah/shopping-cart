package projects.almeida.fernando.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import projects.almeida.fernando.model.CommerceItem;

public interface CommerceItemRepository extends MongoRepository<CommerceItem, String> {

	List<CommerceItem> findItemById();

}
