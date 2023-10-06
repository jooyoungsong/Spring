package spring.anno.last;

public interface ShopInter {

	//인터페이스에서는 변수 못 쓴다. 변수 추가는 웹에가서 할 거에요
	
	public void insertSangpum(String sangpum,int price,String color);
	public void deleteSangpum(String num);
	public void selectShop(String sangpum,int price,String color);
}
