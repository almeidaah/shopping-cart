package projects.almeida.fernando.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import projects.almeida.fernando.model.Product;

public interface ProductRepository extends MongoRepository<Product, String> {

} 
