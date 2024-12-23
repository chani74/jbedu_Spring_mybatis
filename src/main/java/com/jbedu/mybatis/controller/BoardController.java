package com.jbedu.mybatis.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jbedu.mybatis.dao.BoardDao;
import com.jbedu.mybatis.dto.BoardDto;

@Controller
public class BoardController {

	@Autowired
	private SqlSession sqlSession ; // 의존성 작용 주입 - DI
		
	@RequestMapping(value="/write_form")
	public String wrtie_from() {
		return "write_form";
	}
	
	@RequestMapping(value="/writeOk")
	public String boardwrtie(HttpServletRequest request, Model model) {
		
		String bname = request.getParameter("bname");
		String btitle = request.getParameter("btitle");
		String bcontent = request.getParameter("bcontent");
		
		BoardDao boardDao = sqlSession.getMapper(BoardDao.class);
		boardDao.boardWriteDao(bname, btitle, bcontent);
		
		return "redirect:boardList";
	}
	
	@RequestMapping(value="/boardList")
	public String boardList(HttpServletRequest request, Model model) {
		
		BoardDao boardDao = sqlSession.getMapper(BoardDao.class);
		List<BoardDto> boarDtos = boardDao.boardListDao();
		
		model.addAttribute("bDtos", boarDtos);
		
		return "boardList";
	}
	
	@RequestMapping(value="/delete_form")
	public String delete_form() {
		return "delete_form";
	}
	
	@RequestMapping(value="/deleteOk")
	public String boardDelete(HttpServletRequest request, Model model) {
		
		String bnum= request.getParameter("bnum");
		
		BoardDao boardDao = sqlSession.getMapper(BoardDao.class);
		int result = boardDao.boardDeleteDao(bnum);
		if (result != 1) {
			model.addAttribute("msg", "이미 삭제된 번호입니다.");
			model.addAttribute("returnPage", "boardList");
			return "alert";
		}
		
		return "redirect:boardList"; 
	}	
	
	@RequestMapping(value="/boardContent")
	public String boardContent(HttpServletRequest request, Model model) {
		
		String bnum= request.getParameter("bnum");
		
		BoardDao boardDao = sqlSession.getMapper(BoardDao.class);
		boardDao.HitCountDao(bnum);
		BoardDto boardDto = boardDao.boardContentDao(bnum);
		
		model.addAttribute("bDto", boardDto);
		
		return "boardContent";
	}
	
	@RequestMapping(value="/modify_form")
	public String modify_form(HttpServletRequest request, Model model) {
		
		String bnum= request.getParameter("bnum");
		
		BoardDao boardDao = sqlSession.getMapper(BoardDao.class);
		BoardDto boardDto = boardDao.boardContentDao(bnum);
		
		model.addAttribute("bDto", boardDto);
		
		return "modify_form";
	}
	
	@RequestMapping(value="/boardModify")
	public String boardModify(HttpServletRequest request, Model model) {
		
		String bnum = request.getParameter("bnum");
		String bname = request.getParameter("bname");
		String btitle = request.getParameter("btitle");
		String bcontent = request.getParameter("bcontent");
		
		BoardDao boardDao = sqlSession.getMapper(BoardDao.class);
		int result = boardDao.boardUpdateDao(bname, btitle, bcontent, bnum);
		
		if (result != 1) {
			model.addAttribute("msg", "글 수정에 실패하였습니다.");
			model.addAttribute("returnPage", "modify_form?bnum="+bnum);
			return "alert";
		}
		
		return "redirect:boardList"; 
	}
		
}
