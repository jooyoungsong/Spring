package spring.anno.ex5;

import org.springframework.stereotype.Component;

//�����ϱ� : component ���
@Component("tfruit")
public class ThilandFruit implements Fruit {

	@Override
	public void writeFruitName() {
		// TODO Auto-generated method stub

		System.out.println("�±��ϸ� ����!!!");
	}

}
