package spring.mvc.json;

public class PhotoDto {
	
	private String name;
	private String photo;
	
	//�����ϱ� ���� ������ �����
	public PhotoDto(String name, String photo) {
		
		super(); //�̰� �־ �ǰ� ������ ����, �ٸ� �׻� ���� �����ؾ� ��
		this.name=name;
		this.photo=photo;
		
	}

	////setter getter�ϱ�
	
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
