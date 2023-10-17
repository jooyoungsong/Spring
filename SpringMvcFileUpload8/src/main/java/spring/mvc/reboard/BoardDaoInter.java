package spring.mvc.reboard;

import java.util.List;

public interface BoardDaoInter {
	
	public int getTotalCount();
	public int getMaxNum();
	public void updateRestep(int regroup,int restep);
	public void insertReboard(BoardDto dto);
	public List<BoardDto> getPagingList(int start,int perpage);
	public BoardDto getDataReboard(int num);  //상세페이지 보기
	public void updateReadcount(int num); //조회수
	public int getCheckPass(int num,int pass); //비밀번호체크
	public void updateDetail(BoardDto dto); //디테일페이지수정
	public void deleteReboard(int num);  //게시판 글 삭제
	
}
