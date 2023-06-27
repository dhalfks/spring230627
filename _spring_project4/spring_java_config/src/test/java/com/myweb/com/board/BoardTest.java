package com.myweb.com.board;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.myweb.www.domain.BoardVO;
import com.myweb.www.repository.BoardDAO;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {com.myweb.www.config.RootConfig.class})
public class BoardTest {

	@Inject
	private BoardDAO bdao;
	
	@Test
	public void insertBoard() {
		BoardVO bvo = new BoardVO();
		bvo.setTitle("Test title1");
		bvo.setWriter("111@naver.com");
		bvo.setContent("TEST 입니다.");
		
		int isOk = bdao.insertBoard(bvo);
		log.info(">>>> isOk {} > " + (isOk > 0 ? "OK" : "Fail"));
	}
}
