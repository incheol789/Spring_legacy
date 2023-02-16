package com.sh.spring.demo.controller;

import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sh.spring.demo.model.dto.Dev;
import com.sh.spring.demo.model.dto.Gender;
import com.sh.spring.demo.model.service.DemoService;

/**
 * @Controller 클래스의 handler메소드가 가질수 있는 매개변수 타입
 * 
 * HttpServletRequest
 * HttpServletResponse
 * HttpSession
 * 
 * java.util.Locale : 요청에 대한 Locale
 * InputStream/Reader : 요청에 대한 입력스트림
 * OutputStream/Writer : 응답에 대한 출력스트림. ServletOutputStream, PrintWriter
 * 
 * 사용자입력값처리
 * Command객체 : http요청 파라미터를 커맨드객체에 저장한 VO객체
 * CommandMap :  HandlerMethodArgumentResolver에 의해 처리된 사용자입력값을 가진 Map객체
 * @Valid : 커맨드객체 유효성 검사객체
 * Error, BindingResult : Command객체에 저장결과(Command객체 바로 다음위치시킬것.)
 * @PathVariable : 요청url중 일부를 매개변수로 취할 수 있다.
 * @RequestParam : 사용자입력값을 자바변수에 대입처리(필수여부 설정)
 * @RequestHeader : 헤더값
 * @CookieValue : 쿠키값
 * @RequestBody : http message body에 작성된 json을 vo객체로 변환처리
 * 
 * 뷰에 전달할 모델 데이터 설정
 * ModelAndView
 * ModelMap 
 * Model
 
 * @ModelAttribute : model속성에 대한 getter
 * @SessionAttribute : session속성에 대한 getter(required여부 선택가능)
 * @SessionAttributes : session에서 관리될 속성명을 class-level에 작성
 * SessionStatus: @SessionAttributes로 등록된 속성에 대하여 사용완료(complete)처리. 세션을 폐기하지 않고 재사용한다.
 * 
 * 기타
 * MultipartFile : 업로드파일 처리 인터페이스. CommonsMultipartFile
 * RedirectAttributes : DML처리후 요청주소 변경을 위한 redirect시 속성처리 지원
 *
 */
@Controller
@RequestMapping("/demo")
public class DemoController {

	@Autowired
	private DemoService demoService;
	
	/**
	 * handler메소드 : @Controller 하위의 사용자요청 처리 메소드
	 * 
	 * value : path속성에 대한 별칭, value속성명은 유일하게 생략이 가능
	 * 
	 * method 생략시, 모든 전송방식에 대해 처리
	 * - 특정 method등록시, 해당 전송방식만 처리
	 * 
	 * @return
	 */
	@RequestMapping(path = "/devForm.do", method = RequestMethod.GET)
	public String devForm() {
		return "demo/devForm";
	}
	
	@RequestMapping("/dev1.do")
	public String dev1(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		// 1. 사용자입력값처리
		String name = request.getParameter("name");
		int career = Integer.parseInt(request.getParameter("career"));
		String email = request.getParameter("email");
		String _gender = request.getParameter("gender");
		Gender gender = _gender != null ? Gender.valueOf(_gender) : null;
		String[] lang = request.getParameterValues("lang");
		
		Dev dev = new Dev(0, name, career, email, gender, lang, LocalDateTime.now());
		System.out.println("dev = " + dev);
		
		// 2. jsp데이터 전달
		request.setAttribute("dev", dev);
		
		return "demo/devResult";
	}
	
	@RequestMapping("/dev2.do")
	public String dev2(
			@RequestParam("name") String name,
			@RequestParam(defaultValue = "1") int career, // 값생략 또는 변환시 오류가 발생하면 기본값 사용
			@RequestParam String email,
			@RequestParam Gender gender,
			@RequestParam(required = false) String[] lang, // List<String>
			Model model) {
		// 1.사용자입력값 처리
		Dev dev = new Dev(0, name, career, email, gender, lang, LocalDateTime.now());
		System.out.println("dev = " + dev);
		
		// 2. jsp데이터 전달
		model.addAttribute("dev", dev); // requestScope의 속성저장
		
		return "demo/devResult";
	}
	
	/**
	 * 커맨드객체는 이미 모델 속성으로 등록되어 있다.
	 * 
	 * @ModelAttribute 모델속성 가져오기 (생략가능)
	 * 
	 * 
	 * @param dev
	 * @return
	 */
	@RequestMapping("/dev3.do")
	public String dev3(@ModelAttribute Dev dev) {
		dev.setCreatedAt(LocalDateTime.now());
		System.out.println("dev = " + dev);
		
		return "demo/devResult";
	}
	
//	@RequestMapping(path = "/insertDev.do", method = RequestMethod.POST)
	@PostMapping("/insertDev.do")
	public String insertDev(Dev dev, RedirectAttributes redirectAttr) {
		
		int result = demoService.insertDev(dev);
		
		redirectAttr.addFlashAttribute("msg", "정상적으로 개발자정보를 등록했습니다.");
		
		return "redirect:/demo/devList.do";
	}
	
	@GetMapping("/devList.do")
	public String devList(Model model) {
		// 1. 업무로직
		List<Dev> devList = demoService.selectDevList();
		System.out.println("devList = " + devList);
		
		// 2. jsp데이터 전달
		model.addAttribute("devList", devList);
		
		return "demo/devList"; 
	}
	
	
	@GetMapping("/devUpdateForm.do")
	public String updateDev(Model model, @RequestParam int no) {
		
		// 비지니스 로직 
		Dev dev = demoService.selectDevOne(no);
		
		// jsp에 데이터 전달
		model.addAttribute("dev", dev);
		
		return "demo/devUpdateForm";
		
	}
	
	@PostMapping("/updateDev.do")
	public String updateDev(@ModelAttribute Dev dev, RedirectAttributes redirectAttr) {
		
		// 비지니스 로직
		int result = demoService.updateDev(dev);
		

		// 사용자 피드백 및 리다이렉트
		redirectAttr.addFlashAttribute("msg", "개발자 정보 수정 성공~~!");
		
		
		return "redirect:/demo/devList.do";
		
	}
}


















