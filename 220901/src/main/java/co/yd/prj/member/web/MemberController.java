package co.yd.prj.member.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import co.yd.prj.member.service.MemberService;
import co.yd.prj.member.vo.MemberVO;

@Controller
public class MemberController {
	@Autowired
	public MemberService Dao;
	
	@RequestMapping("/memberList.do")
	public String memberList(Model model) {
		model.addAttribute("members", Dao.memberList());
		return "member/memberList";
	}
	
	@RequestMapping("/memberForm.do")
	public String memberForm() {
		return "member/memberForm";
	}
	
	@PostMapping("/memberInsert.do")
	public String memberInsert(MemberVO vo) {
		Dao.memberInsert(vo);
		return "redirect:memberList.do";
	}

}
