package spring.di.ex1;

public class Message1 implements Messageinter {

	//class로 만들어서 add로 messageinter입력후 저장
	
	@Override
	public void sayHello(String name) {
		// TODO Auto-generated method stub

		System.out.println("안녕하세요!!"+name+"님~~");
	}

}
