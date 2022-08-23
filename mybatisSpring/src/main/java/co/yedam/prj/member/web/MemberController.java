package co.yedam.prj.member.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import co.yedam.prj.member.service.MemberService;
import co.yedam.prj.member.vo.MemberVO;

@Controller
public class MemberController {
	@Autowired
	private MemberService service; // dao를 통해 Repository에서 결과를 가져온다
	
	@RequestMapping("/memberList.do") // 라고 들어오면
	public String memberList(Model model) { // 스프링프레임워크에서 제공하는? 인터페이스
		//service 객체를 호출해서 값을 가져오게 처리
		model.addAttribute("members", service.memberSelectList());  
		return "member/memberList";
	}
	
	@RequestMapping("/memberSelect.do")
	public String memberSelect(MemberVO vo, Model model) {
		model.addAttribute("member", service.memberSelect(vo));
		return "member/memberSelect";
	}
		
	
	@RequestMapping("/memberInsert.do")
	public String memberInsert(MemberVO vo, Model model) {
		int n = service.memberInsert(vo);
		if (n !=0 ) {
			model.addAttribute("message", "정상적으로 추가 됨");
		}else {
			model.addAttribute("message", "멤버 추가 실패");
		}
		return "member/memberInsert";
	}
	
	@RequestMapping("memberDelete.do")
	public String memberDelete(MemberVO vo, Model model) {
	int n = service.memberDelete(vo);
	if (n !=0 ) {
		model.addAttribute("message", "정상적으로 삭제 됨");
	}else {
		model.addAttribute("message", "멤버 삭제 실패");
	}
	return "member/memberDelete";
}
	
	@RequestMapping("memberUpdate.do")
	public String memberUpdate(MemberVO vo, Model model) {
		int n = service.memberDelete(vo);
		if (n !=0 ) {
			model.addAttribute("message", "정상적으로 삭제 됨");
		}else {
			model.addAttribute("message", "멤버 삭제 실패");
		}
		return "member/memberUpdate";
	}
}