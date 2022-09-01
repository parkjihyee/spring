package co.yd.prj.member.service;

import java.util.List;

import co.yd.prj.member.vo.MemberVO;

public interface MemberService {
	List<MemberVO> memberList();
	int memberInsert(MemberVO vo);
	
}
