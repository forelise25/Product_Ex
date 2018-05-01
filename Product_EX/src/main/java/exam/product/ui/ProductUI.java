package exam.product.ui;

import java.util.Collection;
import java.util.Scanner;

import exam.product.service.AlreadyExistinProductException;
import exam.product.service.ProductService;
import exam.product.vo.ProductVO;

public class ProductUI {
	ProductService productService;//서비스도 여러개 만들 수 있어! 그니까 인터페이스타입으로 간다. 그리고 이부ㅜㅂㄴ 
	public ProductUI() {}
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	public void showMenu() {
		Scanner scan = new Scanner(System.in);
		String command="";
		
		while(true) 
		{
			System.out.println("명령어를 입력하세요 : ");
			command = scan.nextLine();
			if(command.equalsIgnoreCase("exit")) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
			else if(command.toLowerCase().startsWith("new ")) {
				processNewCommand(command.split(" "));
				continue;
			}
			
			else if(command.toLowerCase().startsWith("search ")) {
				processSearchCommand(command.split(" "));
				continue;
			}
			
			else if(command.toLowerCase().startsWith("change ")) {
				processChangeCommand(command.split(" "));
				continue;
			}
			
			else if(command.toLowerCase().startsWith("delete ")) {
				processDeleteCommand(command.split(" "));
				continue;
			}
			
			else if(command.toLowerCase().startsWith("list")) {
				processListCommand();
				continue;
			}
			//printHelp();
			
		}
	}
	private void processNewCommand(String[] args) {
		if(args.length!=4) {
			return;
		}
		ProductVO product = new ProductVO(args[1], args[2], Integer.parseInt(args[3]));
		try {
			productService.registProduct(product);
		}catch(AlreadyExistinProductException e) {
			System.out.println("임시 존재하는 제품\n");
		}
	}
	private void processSearchCommand(String[] args) {
		if(args.length !=2) {
			return;
		}
		try {
			ProductVO product = productService.getProduct(args[1]);
			System.out.println(product);
		}catch(ProductNotFoundException e) {
			e.getMessage();
			System.out.println("제품이 없다. \n");
		}
	}
	private void processChangeCommand(String[] args) {
		if(args.length != 3) {
			return;
		}
		ProductVO product = new ProductVO(args[1],"",Integer.parseInt(args[2]));
		try {
			productService.changeProductPrice(product);
			System.out.println("제품가격이 변동되었다. \n");
		}catch(ProductNotFoundException e) {
			System.out.println("제품이 없다.\n");
		}
	}
	private void processDeleteCommand(String[] args) {
		if(args.length !=2) {
			return;
		}
		productService.removeProduct(args[1]);
		System.out.println("제품이 삭제되었습니다. \n");
	}
	private void processListCommand() {
		Collection<ProductVO> products = productService.getProducts();
		for(ProductVO product:products) {
			System.out.println(product);
		}
	}
}