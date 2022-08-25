package co.yd.prj;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	
	@RequestMapping(value = "/")
	public String home() {
		return "home";
	}
	
	@GetMapping("/home.do")
	public String home(Model model) { // 매소드 오버로딩(다형성). 동일한 역할을 하는 메소드를 다른 매개변수명으로 정해주는것
		return "home";
	}
}
