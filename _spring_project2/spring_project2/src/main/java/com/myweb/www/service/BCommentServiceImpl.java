package com.myweb.www.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import com.myweb.www.domain.BCommentVO;
import com.myweb.www.domain.PagingVO;
import com.myweb.www.handler.PagingHandler;
import com.myweb.www.repository.BCommentDAO;
import com.myweb.www.repository.BoardDAO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BCommentServiceImpl implements BCommentService{

	@Inject
	private BCommentDAO cdao;
	@Inject
	private BoardDAO bdao;
	
	@Transactional
	@Override
	public int register(BCommentVO cvo) {
		int isUp = cdao.postComment(cvo);
		bdao.updateBoardCmtQty(cvo.getBno(), 1);
		return isUp;
	}

	@Override
	public PagingHandler getList(long bno, PagingVO pgvo) {
		int totalCount = cdao.selectOneBCommentTotalCount(bno);
		List<BCommentVO> list = cdao.selectListBComment(bno, pgvo);
		PagingHandler phd = new PagingHandler(pgvo, totalCount, list);
		return phd;
	}

	@Override
	public int modify(BCommentVO cvo) {
		// TODO Auto-generated method stub
		return cdao.updateBComment(cvo);
	}

	@Override
	public int remove(long cno) {
		Long bno = cdao.selectOneBno(cno);
		int isUp =cdao.deleteBComment(cno);
		bdao.updateBoardCmtQty(bno, -1);
		return isUp;
	}
	
	
}
