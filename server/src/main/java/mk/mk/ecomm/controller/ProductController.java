package mk.mk.ecomm.controller;

import mk.mk.ecomm.exception.ProductException;
import mk.mk.ecomm.model.Product;
import mk.mk.ecomm.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173") // cambiar por las urls de producción
public class ProductController {
  private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

  @Autowired
  private ProductService productService;

  @GetMapping("/products")
  public List<Product> getProducts(){
    var products = productService.showProducts();
    products.forEach((product -> logger.info(product.toString())));
    return products;
  }

  @GetMapping("/products/{id}")
  public ResponseEntity<Product> getProductById(@PathVariable Integer id){
    Product product = productService.findProductById(id);
    if(product == null){
      throw new ProductException("Product Not Found!!");
    }
    return ResponseEntity.ok(product);
  }

  @GetMapping("products/category/{categoryId}")
  public ResponseEntity<List<Product>> getProductsByCategory(@PathVariable Integer categoryId){
    List<Product> products = productService.findProductsByCategoryId(categoryId);
    return ResponseEntity.ok(products);
  }

  @GetMapping("/products/recent")
  public ResponseEntity<List<Product>> getRecentProducts(){
    List<Product> products = productService.findRecentProducts(1);
    return ResponseEntity.ok(products);
  }
}
