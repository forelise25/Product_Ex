package exam.product.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import exam.product.vo.ProductVO;

public class ProductImpl implements ProductDao {
	private Map<String, ProductVO> map = new HashMap<String, ProductVO>();//얘는 우리가 DB구조가 없기때문에 쓸 용도야
	@Override
	public ProductVO selectById(String id) {
		// TODO Auto-generated method stub
		return map.get(id);
	}
	@Override
	public Collection<ProductVO> selectAll() {
		// TODO Auto-generated method stub
		return map.values();
	}
	@Override
	public void insert(ProductVO product) {
		map.put(product.getId(), product); //원래ㅡ이 insert문 이 들어갈 장소임
	}

	@Override
	public void update(ProductVO product) {
		map.put(product.getId(), product);
	}

	@Override
	public void delete(String id) {
		map.remove(id);
	}
}
