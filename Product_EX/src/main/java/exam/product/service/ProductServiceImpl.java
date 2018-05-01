package exam.product.service;

import java.util.Collection;
import java.util.Date;

import exam.product.dao.ProductDao;
import exam.product.vo.ProductVO;

public class ProductServiceImpl implements ProductService {
	
	private ProductDao productDao;
	public ProductServiceImpl(ProductDao productDao) {
		this.productDao = productDao;
	}
	@Override
	public void registProduct(ProductVO newProduct) {
		ProductVO product = productDao.selectById(newProduct.getId());  //똑같은 아이디를 넣었는데 
		if(product != null) { //널이 아니라면 내가 넣은 거는 이미 존재하는 거야!! 그래서 예외 발생
			throw new AlreadyExistinProductException();
		}
		newProduct.setRegisterDate(new Date());
		productDao.insert(newProduct);
	}

	@Override
	public ProductVO getProduct(String id) {
		ProductVO product = productDao.selectById(id);
		//사실여기 널처리도 해줘야해
		return product;
	}

	@Override
	public void changeProductPrice(ProductVO updateProduct) { //여기서 매개변수로 넘겨받는 것들은 다 UI단에서 받을 것 들이야 
		ProductVO product = productDao.selectById(updateProduct.getId());//기존 디비의 행(객체)를 받아옴
		updateProduct.setName(product.getName());
		updateProduct.setRegisterDate(product.getRegisterDate());
		productDao.update(updateProduct);
	}

	@Override
	public void removeProduct(String id) {
		ProductVO product = productDao.selectById(id);
		productDao.delete(id);
	}

	@Override
	public Collection<ProductVO> getProducts() {
		// TODO Auto-generated method stub
		return productDao.selectAll();
	}

}
