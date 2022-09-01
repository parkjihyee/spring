package co.yd.prj.member.map;

import java.util.List;

import co.yd.prj.member.vo.MemberVO;

public interface MemberMapper {
	List<MemberVO> memberList();
	int memberInsert(MemberVO vo);
}
