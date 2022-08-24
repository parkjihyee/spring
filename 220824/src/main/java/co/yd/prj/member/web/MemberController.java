package co.yd.prj.member.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import co.yd.prj.member.service.MemberService;
import co.yd.prj.member.vo.MemberVO;

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
	
	@PostMapping("/memberLogin.do") //vo에는 (id,pw)결과, s에는 로그인 세션, modle에는 메세지 담음
	public String memberLogin(MemberVO vo, HttpSession session, Model model) {
		vo = service.memberSelect(vo);
		if(vo == null) {
			model.addAttribute("message", "id 또는 password를 확인하세요.");
		}else {
			session.setAttribute("id", vo.getMember_id());
			session.setAttribute("name", vo.getMember_name());
			session.setAttribute("author", vo.getMember_author());
			model.addAttribute("message", vo.getMember_name() + "님 환영합니다.");
		}
		return "member/memberMessage";
	}
	
	
	@GetMapping("/memberLoginForm.do")
	public String memberLoginForm() {
		return "member/memberLoginForm";
	}
}