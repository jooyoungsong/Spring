package spring.anno.ex5;

import org.springframework.stereotype.Component;

//빈등록하기 : component 사용
@Component("tfruit")
public class ThilandFruit implements Fruit {

	@Override
	public void writeFruitName() {
		// TODO Auto-generated method stub

		System.out.println("태국하면 망고!!!");
	}

}
