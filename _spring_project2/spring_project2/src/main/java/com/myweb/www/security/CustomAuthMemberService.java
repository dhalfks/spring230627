package com.myweb.www.security;

import javax.inject.Inject;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.myweb.www.repository.MemberDAO;

public class CustomAuthMemberService implements UserDetailsService {
	
	@Inject
	private MemberDAO mdao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		MemberVO mvo = mdao.selectEmail(username);
		mvo.setAuthList(mdao.selectAuths(username));
		return new AuthMember(mvo);
	}

}
