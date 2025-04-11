package mk.mk.ecomm.service;

import mk.mk.ecomm.model.Product;
import mk.mk.ecomm.repository.CategoryRepository;
import mk.mk.ecomm.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProductService implements IProductService{

  @Autowired
  private ProductRepository productRepository;

  @Autowired
  private CategoryRepository categoryRepository;

  @Override
  public List<Product> showProducts() {
    return productRepository.findAll();
  }

  @Override
  public Product findProductById(Integer productId) {
    Product product = productRepository.findById(productId).orElse(null);
    return product;
  }

  @Override
  public List<Product> findProductsByCategoryId(Integer categoryId) {
    return productRepository.findByCategoryCategoryId(categoryId);
  }

  @Override
  public List<Product> findRecentProducts(Integer days) {
    LocalDateTime startDate = LocalDateTime.now().minusDays(days);
    List<Product> products = productRepository.findRecentProducts(startDate);
    return products;
  }



}
