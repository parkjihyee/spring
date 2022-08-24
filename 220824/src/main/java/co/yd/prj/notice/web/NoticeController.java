package co.yd.prj.notice.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import co.yd.prj.notice.service.NoticeService;
import co.yd.prj.notice.vo.NoticeVO;

@Controller
public class NoticeController {
	@Autowired // 컨테이너에 들어있는 것만 불러올 수 있음
	private NoticeService dao;
	
	@RequestMapping("/noticeList.do")
	public String noticeList(Model model) {
		model.addAttribute("notices", dao.noticeSelectList());
		return "notice/noticeList";
	}
	
	@RequestMapping("/noticeForm.do") // 입력 폼 호출
	public String noticeForm() {
		return "notice/noticeForm";
	}
	
	@PostMapping("/noticeInsert.do") // 글 등록
	public String noticeInSert(NoticeVO vo, MultipartFile mFile) { //첨부파일 안 함?
		//요 부분에 첨부파일 처리
		dao.noticeInsert(vo); // 글 내용 등록
		return "redirect:noticeList.do"; // 글 목록으로 돌아가기
		//redirect를 쓰면 디스패쳐가 컨트롤러한테 받은 요청을 view resolve가 아니라 Handler mapper로 보냄

	}
}
