package com.simple.basic.service.memo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simple.basic.command.MemoVO;

@Service("memoService") //고유한이름
public class MemoServiceImpl implements MemoService {
	
	@Autowired
	MemoMapper memoMapper;

	@Override
	public void memoInsert(MemoVO vo) {
		memoMapper.memoInsert(vo);
	}

	@Override
	public List<MemoVO> getList() {
		return memoMapper.getList();
	}

	@Override
	public MemoVO getDetail(int mno) {
		
		return memoMapper.getDetail(mno);
	}
	
}
