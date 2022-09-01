package co.yd.prj.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.yd.prj.member.map.MemberMapper;
import co.yd.prj.member.vo.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberMapper map;
	
	@Override
	public List<MemberVO> memberList() {
		return map.memberList();
	}


	@Override
	public int memberInsert(MemberVO vo) {
		return map.memberInsert(vo);
	}

}
