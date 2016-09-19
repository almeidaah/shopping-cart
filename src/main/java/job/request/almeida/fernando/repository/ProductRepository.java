package job.request.almeida.fernando.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import job.request.almeida.fernando.model.Product;

public interface ProductRepository extends MongoRepository<Product, String> {

} 
