package projects.almeida.fernando.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import projects.almeida.fernando.model.CommerceItem;
import projects.almeida.fernando.model.ShoppingCart;
import projects.almeida.fernando.service.ShoppingCartService;

@RestController
@RequestMapping(value="/sm/api/v1")
public class ShoppingCartController {

	@Autowired 
	private ShoppingCartService shoppingCartService;
	
	/**
	 * Returns the current shopping cart for the session.
	 * @param id
	 * @return Shoppingcart
	 */
	@RequestMapping(value = "/shoppingcart", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ShoppingCart> shoppingcartGet(){
		HttpHeaders httpHeaders = new HttpHeaders();
		ShoppingCart shoppingCart = shoppingCartService.getSessionShoppingCart();
		return new ResponseEntity<ShoppingCart>(shoppingCart, httpHeaders, HttpStatus.OK);
	}
	
	/**
	 * Removes an commerce item from the shopping cart, by commerce item id.
	 * @param id
	 */
	@RequestMapping(value = "/shoppingcart/items/{id}", method = RequestMethod.DELETE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> shoppingcartItemsIdDelete(@RequestParam(required=true) String id){
		HttpHeaders httpHeaders = new HttpHeaders();
		shoppingCartService.delete(id);
		return new ResponseEntity<>("Item was removed from the shopping cart.", httpHeaders, HttpStatus.OK);
	}
	
	/**
	 * Adds an item to the shopping cart. 
	 * @param product_id
	 * @param quantity
	 */
	@RequestMapping(value = "/shoppingcart/items", method = RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CommerceItem> shoppingcartItemsPost(HttpSession httpSession, @RequestParam(required=true) String product_id, @RequestParam(required=true) Integer quantity){
		HttpHeaders httpHeaders = new HttpHeaders();
		CommerceItem commerceItem = new CommerceItem(product_id, quantity);
		shoppingCartService.insert(commerceItem);
		return new ResponseEntity<>(commerceItem, httpHeaders, HttpStatus.OK);
	}
	
	/**
	 * Adds an item to the shopping cart. 
	 * @param product_id
	 * @param quantity
	 */
	@RequestMapping(value = "/shoppingcart/total", method = RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Double> getTotalShoppingCartCosts(HttpSession httpSession){

		//Get shoppingcart from session 
	    	ShoppingCart shoppingCart = shoppingCartService.findOne(String.valueOf(httpSession.getAttribute("cart_id")));
	    	
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<Double>(shoppingCart.getTotalCosts(), httpHeaders, HttpStatus.OK);

	}
}
