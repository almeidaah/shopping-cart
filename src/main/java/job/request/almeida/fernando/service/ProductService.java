package job.request.almeida.fernando.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import job.request.almeida.fernando.model.Product;
import job.request.almeida.fernando.repository.ProductRepository;

@Service
public class ProductService {
    
    @Autowired
    private ProductRepository productRepository;

    @Transactional
    public List<Product> findAll() {
	return productRepository.findAll();
    }
}
