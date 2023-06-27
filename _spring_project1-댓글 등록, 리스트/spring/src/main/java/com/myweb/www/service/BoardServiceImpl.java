package com.myweb.www.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.myweb.www.domain.BoardVO;
import com.myweb.www.domain.PagingVO;
import com.myweb.www.domain.UserVO;
import com.myweb.www.repository.BoardDAO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BoardServiceImpl implements BoardService {

	@Inject
	private BoardDAO bdao;

	@Override
	public int register(BoardVO bvo) {
		log.info("board reigster in");
		return bdao.insert(bvo);
	}

	@Override
	public List<BoardVO> getList() {
		log.info("board list in");
		return bdao.getList();
	}

	@Override
	public BoardVO getDetail(int bno) {
		log.info("board detail in");
		return bdao.getDetail(bno);
	}

	@Override
	public int readCount(int bno) {
		// TODO Auto-generated method stub
		return bdao.readCount(bno);
	}

	@Override
	public int modify(BoardVO bvo, UserVO user) {
		log.info("board modify in");
		BoardVO tmpBoard = bdao.getDetail(bvo.getBno()); //해당 글의 게시글 호출
		if(user ==null || !user.getId().equals(tmpBoard.getWriter())){
			return 0;
		}
		return bdao.updateBoard(bvo);
	}

	@Override
	public int remove(int bno, UserVO user) {
		log.info("board remove in");
		BoardVO tmpBoard = bdao.getDetail(bno); //해당 글의 게시글 호출
		if(user ==null || !user.getId().equals(tmpBoard.getWriter())){
			return 0;
		}
		return bdao.deleteBoard(bno);
	}

	@Override
	public List<BoardVO> getList(PagingVO pvo) {
		log.info("board PagingList in");
		return bdao.selectBoardListPaging(pvo);
	}

	@Override
	public int getTotalCount(PagingVO pvo) {
		// TODO Auto-generated method stub
		return bdao.getTotalCount(pvo);
	}

	
}
