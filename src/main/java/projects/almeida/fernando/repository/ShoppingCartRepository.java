package projects.almeida.fernando.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import projects.almeida.fernando.model.ShoppingCart;

public interface ShoppingCartRepository extends MongoRepository<ShoppingCart, String> {

}
