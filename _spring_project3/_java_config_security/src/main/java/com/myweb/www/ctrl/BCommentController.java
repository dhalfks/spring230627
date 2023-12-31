package com.myweb.www.ctrl;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myweb.www.domain.BCommentVO;
import com.myweb.www.domain.PagingVO;
import com.myweb.www.handler.PagingHandler;
import com.myweb.www.service.BCommentService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/bcomment/*")
@Controller
public class BCommentController {
	
	@Inject
	private BCommentService csv;
	
	@PutMapping(value = "/{cno}", consumes = "application/json",
			produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> edit(@PathVariable("cno") long cno, 
										@RequestBody BCommentVO cvo){
		return csv.modify(cvo) > 0 ?
				new ResponseEntity<String>("1", HttpStatus.OK)
				: new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@DeleteMapping(value = "/{cno}", produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> erase(@PathVariable("cno") long cno){
		return csv.remove(cno) > 0 ?
				new ResponseEntity<String>("1", HttpStatus.OK)
				: new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping(value = "/{bno}/{page}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<PagingHandler> spread(@PathVariable("bno") long bno,
			@PathVariable("page")int page){
		log.debug(">>> bcooment bno :{}/{}", bno, page);
		PagingVO pgvo = new PagingVO(page, 10);

		
		return new ResponseEntity<PagingHandler>(csv.getList(bno, pgvo),
									HttpStatus.OK);
	}
	
	@PostMapping(value = "/post", consumes = "application/json", 
			produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> post(@RequestBody BCommentVO cvo){
		log.debug(">>> {}", cvo);		
		return csv.register(cvo) > 0 ?
				new ResponseEntity<String>("1", HttpStatus.OK)
				: new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
