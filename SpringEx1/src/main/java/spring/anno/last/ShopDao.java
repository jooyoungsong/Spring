package spring.anno.last;

import org.springframework.stereotype.Component;

@Component()  //빈등록은 무조건 component사용 근데,웹에서는 이게 3가지로 나뉜다고 말했음!(service/repositary/controller)
public class ShopDao implements ShopInter {

	@Override
	public void insertSangpum(String sangpum, int price, String color) {
		// TODO Auto-generated method stub
		System.out.println(sangpum+":"+price+":"+color);
	}

	@Override
	public void deleteSangpum(String num) {
		// TODO Auto-generated method stub
		System.out.println(num+"번 삭제됨");
	}

	@Override
	public void selectShop(String sangpum, int price, String color) {
		// TODO Auto-generated method stub
		System.out.println("**상품관리**");
		System.out.println("상품명: "+sangpum);
		System.out.println("가격: "+price);
		System.out.println("색상: "+color);
	}

}
