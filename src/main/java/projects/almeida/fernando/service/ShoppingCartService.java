package projects.almeida.fernando.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import projects.almeida.fernando.model.CommerceItem;
import projects.almeida.fernando.model.ShoppingCart;
import projects.almeida.fernando.repository.CommerceItemRepository;
import projects.almeida.fernando.repository.ShoppingCartRepository;

@Service
public class ShoppingCartService {

    @Autowired
    private ShoppingCartRepository shoppingCartRepo;

    @Autowired
    private CommerceItemRepository commerceItemRepo;

    @Autowired
    private HttpSession		   httpSession;

    @Transactional
    public ShoppingCart findOne(String id) {
	return shoppingCartRepo.findOne(id);
    }

    @Transactional
    public void save(ShoppingCart shoppingCart) {
	shoppingCartRepo.save(shoppingCart);
    }

    public void delete(String id) {
	ShoppingCart shoppingCart = getSessionShoppingCart();
	CommerceItem item = commerceItemRepo.findOne(id);
	shoppingCart.getCommerceItems().remove(item);
	httpSession.setAttribute("shoppingcart", shoppingCart);
    }
    
    public void insert(CommerceItem commerceItem) {
	ShoppingCart shoppingCart = getSessionShoppingCart();
	shoppingCart.getCommerceItems().add(commerceItem);
	httpSession.setAttribute("shoppingcart", shoppingCart);
}

    public ShoppingCart getSessionShoppingCart() {
	ShoppingCart shoppingCart = (ShoppingCart) this.httpSession.getAttribute("shoppingcart");
	if (shoppingCart == null) {
	    shoppingCart = new ShoppingCart();
	    this.httpSession.setAttribute("shoppingcart", shoppingCart);
	}
	return shoppingCart;
    }
}
