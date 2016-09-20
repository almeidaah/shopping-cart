package job.request.almeida.fernando.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import job.request.almeida.fernando.model.Product;
import job.request.almeida.fernando.service.ProductService;

@RestController
@RequestMapping(value = "/sm/api/v1")
public class ProductController {

	@Autowired
	private ProductService productService;

	/**
	 * The Products endpoint returns information about the *McFadyen* products.
	 * @return List<Product>
	 */
	@RequestMapping(value = "/products", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Product>> productsGet() {

		HttpHeaders httpHeaders = new HttpHeaders();
		List<Product> products = productService.findAll();
		
		return new ResponseEntity<List<Product>>(products, httpHeaders, HttpStatus.OK);
	}
}
