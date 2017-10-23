package com.djunderworld.jstay.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.djunderworld.jstay.common.dao.User;
import com.djunderworld.jstay.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	/**
	 * 이메일 중복체크 API
	 * 
	 * @author dongjooKim
	 * 
	 * 
	 * @param email
	 * @return Boolean
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/emailCheck.json", method = RequestMethod.GET)
	@ResponseBody
	public Boolean emailCheck(@RequestParam("email") String email) throws Exception {
		return userService.getCheckByEmail(email);
	}
	
	/**
	 * 로그인 API (성공시, 엑세스토큰이 담긴 User 반환, 실패시, null)
	 * 
	 * @author dongjooKim
	 * 
	 * @param email
	 * @param password
	 * @return User
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/login.json", method = RequestMethod.GET)
	@ResponseBody
	public User login(@RequestParam("email") String email,
			@RequestParam("password") String password) throws Exception {
		return userService.getUserByEmailAndPassword(email, password);
	}
	
	/**
	 * 회원가입  API
	 * 
	 * @author dongjooKim
	 * 
	 * @param user
	 * @return redirect:login
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String join(@RequestBody User user, RedirectAttributes redirectAttributes) throws Exception {
		userService.saveUser(user);

		String email = user.getEmail();
		String password = user.getPassword();

		redirectAttributes.addAttribute("email", email);
		redirectAttributes.addAttribute("password", password);
		
		return "redirect:/users/login.json";
	}
	
	/**
	 * 유저 정보 수정 API(파일: 아바타 사진)
	 * 
	 * @author dongjooKim
	 * 
	 * @param id
	 * @param user
	 * @param file
	 * @return User
	 * 
	 * @throws Exception
	 */
	@Secured("ROLE_USER")
	@RequestMapping(value = "/{id}", method = { RequestMethod.POST, RequestMethod.PUT })
	@ResponseBody
	public User updateUserById(@PathVariable long id, @RequestPart User user,
			@RequestPart(required = false) List<MultipartFile> files) throws Exception {
		return userService.updateUserByIdAndMultipartFiles(user, files);
	}

}
