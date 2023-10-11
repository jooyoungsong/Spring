package spring.mysql.mycar;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//mycarMapper(sql)-> dao -> controller로 간다.
@Repository //Dao에서 bean에 등록하는 법
public class MyCarDao {

	@Autowired
	SqlSession session;  //private SqlSession session;으로 적어도 된다. SqlSession이라는 인터페이스가 따로 있는 것!
	//위에 SqlSession은 session과 다른 것이다. 
	//SqlSession은 Mapper에서 정의한 sql문을 처리하는 session이다.
	
	String namespace="spring.mysql.mycar.MyCarDao";  //mapper에 있는 namespace를 가리킴
	
	//O개의 자동차가 등록되었습니다
	public int getTotalCount()
	{
		return session.selectOne(namespace+".getTotalCount");  //괄호안에서 getTotalCount는 mapper폴더의 id값을 쓴 것
		//mycar.getTotalCountOfMyCar로 써도 된다.
		//mycarMapper에서 id값을 반드시 복사해오세요
	}
	
	//insert
	public void insertCar(MyCarDto dto)
	{
		session.insert("insertOfMycar", dto); //mapper 아이디값 가져와서 괄호 왼족에 써주기!
	}
	
	//select _ 전체목록조회 
	public List<MyCarDto> getAllcars()
	{
		return session.selectList("getAllListOfMyCar");
	}
	
	//삭제 (mapper->dao)
	public void deleteCar(String num)
	{
		session.delete("deleteOfMyCar",num);  //괄호안에 "id값" 가져옴
	}
	
	//업데이트_(1)업데이트할 문장 가져오기
	public MyCarDto getDataOfMyCar(String num)
	{
		return session.selectOne("getDataOfMyCar", num);
	}
	
	//업데이트_(2)업데이트
	public void updateCar(MyCarDto dto)
	{
		session.update("updateOfMyCar",dto);
	}
}
