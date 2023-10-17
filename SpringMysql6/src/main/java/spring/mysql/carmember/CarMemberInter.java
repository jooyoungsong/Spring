package spring.mysql.carmember;

import java.util.List;

public interface CarMemberInter {

	public int getTotalCount();
	
	//insert
	public void insert(CarMemberDto dto);

	//allselect
	public List<CarMemberDto> selectCarMember();
	
	//getdata
	public CarMemberDto getData(int num);
	
	//update
	public void updateCarMember(CarMemberDto dto);
	
	//delete
	public void deleteCarMember(int num);
}
