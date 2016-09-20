package job.request.almeida.fernando.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import job.request.almeida.fernando.model.CommerceItem;
import job.request.almeida.fernando.model.ShoppingCart;
import job.request.almeida.fernando.service.CommerceItemService;
import job.request.almeida.fernando.service.ShoppingCartService;

@RestController
@RequestMapping(value="/sm/api/v1")
public class ShoppingCartController {

	@Autowired
	private CommerceItemService commerceItemService;
	
	@Autowired 
	private ShoppingCartService shoppingCartService;
	
	/**
	 * Returns the current shopping cart for the session.
	 * @param id
	 * @return Shoppingcart
	 */
	@RequestMapping(value = "/shoppingCart", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ShoppingCart> shoppingcartGet(String id){

		HttpHeaders httpHeaders = new HttpHeaders();
		ShoppingCart shoppingCart = shoppingCartService.findOne(id);
		
		return new ResponseEntity<ShoppingCart>(shoppingCart, httpHeaders, HttpStatus.OK);
	}
	
	/**
	 * Removes an commerce item from the shopping cart, by commerce item id.
	 * @param id
	 */
	@RequestMapping(value = "/shoppingcart/items/{id}", method = RequestMethod.DELETE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> shoppingcartItemsIdDelete(@RequestParam(required=true) String id){

		HttpHeaders httpHeaders = new HttpHeaders();
		commerceItemService.delete(id);
		
		return new ResponseEntity<>("Item was removed from the shopping cart.", httpHeaders, HttpStatus.OK);
	}
	
	/**
	 * Adds an item to the shopping cart. 
	 * @param product_id
	 * @param quantity
	 */
	@RequestMapping(value = "/shoppingcart/items", method = RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CommerceItem> shoppingcartItemsPost(@RequestParam(required=true) String product_id, @RequestParam(required=true) Integer quantity){

		//Get shoppingcart from session 
		HttpHeaders httpHeaders = new HttpHeaders();
		
		CommerceItem item = new CommerceItem(product_id, quantity);
		commerceItemService.save(item);
		
		return new ResponseEntity<>(item, httpHeaders, HttpStatus.OK);

	}
}
