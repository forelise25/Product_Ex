package exam.product.service;

import java.util.Collection;

import exam.product.vo.ProductVO;

public interface ProductService {
	public void registProduct(ProductVO product);
	public ProductVO getProduct(String id);
	public void changeProductPrice(ProductVO product);
	public void removeProduct(String id);
	public Collection<ProductVO> getProducts();
}
