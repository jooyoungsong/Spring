package spring.mysql.mycar;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//mycarMapper(sql)-> dao -> controller�� ����.
@Repository //Dao���� bean�� ����ϴ� ��
public class MyCarDao {

	@Autowired
	SqlSession session;  //private SqlSession session;���� ��� �ȴ�. SqlSession�̶�� �������̽��� ���� �ִ� ��!
	//���� SqlSession�� session�� �ٸ� ���̴�. 
	//SqlSession�� Mapper���� ������ sql���� ó���ϴ� session�̴�.
	
	String namespace="spring.mysql.mycar.MyCarDao";  //mapper�� �ִ� namespace�� ����Ŵ
	
	//O���� �ڵ����� ��ϵǾ����ϴ�
	public int getTotalCount()
	{
		return session.selectOne(namespace+".getTotalCount");  //��ȣ�ȿ��� getTotalCount�� mapper������ id���� �� ��
		//mycar.getTotalCountOfMyCar�� �ᵵ �ȴ�.
		//mycarMapper���� id���� �ݵ�� �����ؿ�����
	}
	
	//insert
	public void insertCar(MyCarDto dto)
	{
		session.insert("insertOfMycar", dto); //mapper ���̵� �����ͼ� ��ȣ ������ ���ֱ�!
	}
	
	//select _ ��ü�����ȸ 
	public List<MyCarDto> getAllcars()
	{
		return session.selectList("getAllListOfMyCar");
	}
	
	//���� (mapper->dao)
	public void deleteCar(String num)
	{
		session.delete("deleteOfMyCar",num);  //��ȣ�ȿ� "id��" ������
	}
	
	//������Ʈ_(1)������Ʈ�� ���� ��������
	public MyCarDto getDataOfMyCar(String num)
	{
		return session.selectOne("getDataOfMyCar", num);
	}
	
	//������Ʈ_(2)������Ʈ
	public void updateCar(MyCarDto dto)
	{
		session.update("updateOfMyCar",dto);
	}
}
