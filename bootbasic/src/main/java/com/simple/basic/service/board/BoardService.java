package com.simple.basic.service.board;

import java.util.List;
import java.util.Map;

import com.simple.basic.command.BoardVO;

public interface BoardService {

	public boolean insert(BoardVO vo);
	public List<BoardVO> getList(); //전체목록조회
	public BoardVO getDetail(int bno); //1개 목록 조회
	public boolean delete(int bno); //글 삭제
	
}
