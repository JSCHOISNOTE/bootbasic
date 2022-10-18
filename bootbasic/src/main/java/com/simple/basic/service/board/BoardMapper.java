package com.simple.basic.service.board;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.simple.basic.command.BoardVO;

@Mapper //부트에서는 매퍼로 사용할 인터페이스에 반드시 붙입니다.
public interface BoardMapper {
//	public boolean insert(int a); #{a}
//	public boolean insert(Map<String, Object> map); //#{key}
//	public String getTime();
	public boolean insert(BoardVO vo);
	public List<BoardVO> getList(); //전체목록조회
	public BoardVO getDetail(int bno); //1개 목록 조회
	public boolean delete(int bno); //글 삭제
}


