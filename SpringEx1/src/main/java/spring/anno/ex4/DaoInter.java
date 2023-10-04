package spring.anno.ex4;

public interface DaoInter {
	
	public void insertData(String str);
	public void deleteData(String num);
	
	//인터페이스는 bean에 등록할 필요 없다.
}
