package com.simple.basic.service.memo;

import java.util.List;

import com.simple.basic.command.MemoVO;

public interface MemoService {

	public void memoInsert(MemoVO vo);
	public List<MemoVO> getList();
	public MemoVO getDetail(int mno);
}
