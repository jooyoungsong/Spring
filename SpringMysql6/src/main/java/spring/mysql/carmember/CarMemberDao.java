package spring.mysql.carmember;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CarMemberDao implements CarMemberInter {

	@Autowired // 객체 생성 역할 new~~
	private SqlSession session;
	
	@Override
	public int getTotalCount() {
		// TODO Auto-generated method stub
		return session.selectOne("getTotalCountOfCarMember"); //mapper에서의 id를 써줘야함
	}

	@Override
	public void insert(CarMemberDto dto) {
		// TODO Auto-generated method stub
		
		session.insert("insertOfCarMember", dto);
	}

	@Override
	public List<CarMemberDto> selectCarMember() {
		// TODO Auto-generated method stub
		
		return session.selectList("selectOfCarMember");
		
	}

	@Override
	public CarMemberDto getData(int num) {
		// TODO Auto-generated method stub
		return session.selectOne("getDataOfCarMember",num);
	}

	@Override
	public void updateCarMember(CarMemberDto dto) {
		// TODO Auto-generated method stub
		
		session.update("updateOfCarMember",dto);
		
	}

	@Override
	public void deleteCarMember(int num) {
		// TODO Auto-generated method stub
		
		session.delete("deleteOfCarMember", num);
	}

}
