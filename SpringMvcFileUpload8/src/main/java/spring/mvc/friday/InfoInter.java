package spring.mvc.friday;

import java.util.List;

public interface InfoInter {
//�������̽��� �߻� �޼��常 ��Ƴ��� ���̴�
	
	public int getTotalCount();
	public void insertMyinfo(InfoDto dto); //insert
	public List<InfoDto> getAllInfos();  //select
	public InfoDto getData(String num);  //update1
	public void updateMyInfo(InfoDto dto);  //update2
	public void deleteInfo(String num); //delete
}
