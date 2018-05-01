package exam.product.dao;

import java.util.Collection;

import exam.product.vo.ProductVO;

public interface ProductDao {
	//선생님 그러면 나중에 d오라클디비로 변경할때 아얘 얘만 
	public ProductVO selectById(String id); //ProductVO왜냐면 이 메서드는 아이디로 검색한 객체를 반환 할 거거든
	public void insert(ProductVO product);
	public void update(ProductVO product);
	public void delete(String id);
	
	public Collection<ProductVO> selectAll();
}
