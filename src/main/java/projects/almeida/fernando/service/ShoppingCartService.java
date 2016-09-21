package projects.almeida.fernando.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import projects.almeida.fernando.model.ShoppingCart;
import projects.almeida.fernando.repository.ShoppingCartRepository;

@Service
public class ShoppingCartService {

    @Autowired
    private ShoppingCartRepository shoppingCartRepo;
    
    @Transactional
    public ShoppingCart findOne(String id){
	return shoppingCartRepo.findOne(id);
    }
    
    @Transactional
    public void save(ShoppingCart shoppingCart){
	shoppingCartRepo.save(shoppingCart);
    }
}
