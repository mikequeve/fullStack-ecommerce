package mk.mk.ecomm.service;

import mk.mk.ecomm.model.Product;

import java.util.List;

public interface IProductService {
  public List<Product> showProducts();
  public Product findProductById(Integer productId);
  public List<Product> findProductsByCategoryId(Integer categoryId);
  public List<Product> findRecentProducts(Integer startDate);
}
