package spring.mvc.friday;

import java.util.List;

public interface InfoInter {
//인터페이스는 추상 메서드만 모아놓은 것이다
	
	public int getTotalCount();
	public void insertMyinfo(InfoDto dto); //insert
	public List<InfoDto> getAllInfos();  //select
	public InfoDto getData(String num);  //update1
	public void updateMyInfo(InfoDto dto);  //update2
	public void deleteInfo(String num); //delete
}
