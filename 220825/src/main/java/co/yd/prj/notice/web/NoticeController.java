package co.yd.prj.notice.web;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import co.yd.prj.notice.service.NoticeService;
import co.yd.prj.notice.service.NoticeVO;

@Controller
public class NoticeController {
	@Autowired
	private NoticeService ns;
	
	@Autowired
	private ServletContext servletContext; //컨테이너에 있는 contextpath(webapp)를 찾는것
	
	@PostMapping("/noticeSelect.do") // 단 건 조회
	public String noticeSelect(NoticeVO vo, Model model) { 
		//vo.setNoticeId(23); // 강제로 하나의 레코드를 선택하기 위해 만든 것
		model.addAttribute("n", ns.noticeSelect(vo));
		ns.noticeHitUpdate(vo); //조회수 증가
		return "notice/noticeSelect";
	}
	
	@GetMapping("/noticeSelectList.do") // 리스트 조회
	public String noticeSelectList(Model model) {
		model.addAttribute("notices", ns.noticeSelectList()); // 구분하기쉬우려고 notices로 함!
		return "notice/noticeSelectList";
	}
	
	@PostMapping("/noticeInsert.do")
	public String noticeInSert(NoticeVO vo, @RequestParam("file") MultipartFile file) 
			throws IllegalStateException, IOException { // 실제로 file이라는 이름으로 올라오는것을
//		vo.setNoticeWriter("관리자");
//		vo.setNoticeTitle("공지사항임다");
//		vo.setNoticeSubject("내용은 없음. 낫띵");
		
		//파일업로드 처리
		String saveFolder = servletContext.getRealPath("/fileUpload"); // 저장할 공간 폴더 명
		File sfile = new File(saveFolder); // sfile: 물리적 저장할 위치
		String oFileName = file.getOriginalFilename(); // 넘어온 파일의 이름
		
		if(!oFileName.isEmpty()) {
		// 자바 UUID 객체로 : 파일명 충돌방지를 위한 파일 별명 만들기
		String sFileName = UUID.randomUUID().toString() + oFileName.substring(oFileName.lastIndexOf(".")); // 고유한 랜덤아이디 + (.jsp*)확장자명을 잘라서붙임
		file.transferTo(new File(sfile, sFileName)); //파일을 물리적 위치에 저장한다. sfile 공간에 sFileName(UUID)이름으로 저장하자
		vo.setNoticeAttech(oFileName);
		vo.setNoticeAttechdir(saveFolder + File.separator + sFileName); //fileUpload/273747.txt
		}
		
		ns.noticeInsert(vo); // 행위를 실행시킨다
		return "redirect:noticeSelectList.do";
	}
	
	@RequestMapping("/noticeUpdate.do")
	public String noticeUpdate(NoticeVO vo){
		vo.setNoticeWriter("관리자");
		vo.setNoticeId(24); // 강제로 
		ns.noticeUpdate(vo);
		return "redirect:noticeSelectList.do"; //디스패쳐가 핸들러 매퍼로 다시 돌려보냄 -> 그래서 다시 컨트롤러에서 리턴을 찾음
	}
	
	@RequestMapping("/noticeSearch.do") // vo객체가 아닌 다른 변수명으로 되어있는것들은 이렇게 받음
	public String noticeSearch(NoticeVO vo, String key, //@RequestParm("key)
			String val, Model model) {
		
		key = "1";
		val = "에서";
		model.addAttribute("notices", ns.noticeSearch(key, val));
		return "notice/noticeSearch";
	}
	
	@GetMapping("/noticeForm.do")
	public String noticeInsertForm() {
		return "notice/noticeForm";
	}
	
	@RequestMapping(value = "/ajaxNoticeSelect.do", produces = "application/text; charset=UTF-8")
	@ResponseBody // 호출한 페이지로 결과를 돌려보내준다.
	public String ajaxNoticeSelect(HttpServletResponse response) {
		//response.setContentType("text/html; charset=UTF-8");
		String message = "ajax Test 해 봄";
		return message;
	}
	
	@GetMapping("/ajaxTest.do")
	public String ajaxTest() {
		return "notice/ajaxTest";
	}
}
