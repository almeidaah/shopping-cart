package job.request.almeida.fernando.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import job.request.almeida.fernando.model.ShoppingCart;

public interface ShoppingCartRepository extends MongoRepository<ShoppingCart, String> {

}
