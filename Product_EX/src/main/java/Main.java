import exam.product.dao.ProductDao;
import exam.product.dao.ProductImpl;
import exam.product.service.ProductService;
import exam.product.service.ProductServiceImpl;
import exam.product.ui.ProductUI;

public class Main {
	public static void main(String[] args){
		ProductDao productDao = new ProductImpl();
		ProductService productService = new ProductServiceImpl(productDao);
		ProductUI productUI = new ProductUI();
		productUI.setProductService(productService);
		productUI.showMenu();	
	}
}
