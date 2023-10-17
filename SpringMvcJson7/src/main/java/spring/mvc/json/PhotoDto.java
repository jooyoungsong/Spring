package spring.mvc.json;

public class PhotoDto {
	
	private String name;
	private String photo;
	
	//생성하기 쉽게 생성자 만들고
	public PhotoDto(String name, String photo) {
		
		super(); //이건 넣어도 되고 생략도 가능, 다만 항상 위에 존재해야 함
		this.name=name;
		this.photo=photo;
		
	}

	////setter getter하기
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	
}
