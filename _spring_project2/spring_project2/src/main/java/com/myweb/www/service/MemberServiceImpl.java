package com.myweb.www.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myweb.www.repository.MemberDAO;
import com.myweb.www.security.MemberVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MemberServiceImpl implements MemberService{

	@Inject
	private MemberDAO mdao;

	@Transactional
	@Override
	public boolean updateLastLogin(String authEmail) {
		// TODO Auto-generated method stub
		return mdao.updateLastLogin(authEmail) >0 ? true:false;
	}

	@Override
	public int register(MemberVO mvo) {
		mdao.insertMember(mvo);
		return mdao.insertAuthInit(mvo.getEmail());
	}
}
