package com.example.demo.controller.rest;

<<<<<<< HEAD
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.BookException;
import com.example.demo.model.dto.BookDto;
import com.example.demo.response.ApiResponse;
import com.example.demo.service.BookService;

/**
 * GET GET POST PUT DELETE
 */

@RestController
@RequestMapping("/rest/book")
@CrossOrigin(origins = { "http://localhost:8082" }, allowCredentials = "true")
public class BookRestController {

	@Autowired
	private BookService bookService;

	@GetMapping
	public ResponseEntity<ApiResponse<List<BookDto>>> getBooks() {
		List<BookDto> bookDtos = bookService.getAllBooks();
		String message = bookDtos.isEmpty() ? "查無資料" : "查詢成功";
		return ResponseEntity.ok(ApiResponse.success(message, bookDtos));
	}
	//新增書籍
	@PostMapping
	public ResponseEntity<ApiResponse<BookDto>>addBook(@RequestBody BookDto bookDto){
		bookService.addBook(bookDto);
		return ResponseEntity.ok(ApiResponse.success("書籍新增成功", bookDto));//null是data
	} 
	//取得單筆
	@GetMapping("/{bookId}")
	public ResponseEntity<ApiResponse<BookDto>>getBook(@PathVariable Integer bookId){
		BookDto bookDto=bookService.getBookById(bookId).orElseThrow();
		return ResponseEntity.ok(ApiResponse.success("書籍查詢單筆成功", bookDto));
	}
	
	@PutMapping("/{bookId}")
	public ResponseEntity<ApiResponse<BookDto>>updateBook(@RequestBody BookDto bookDto){
		bookDto.setBookId(bookDto.getBookId());
		bookService.updateBook(bookDto);
		return ResponseEntity.ok(ApiResponse.success("書籍修改成功", bookDto));
	}
	
	@DeleteMapping("/{bookId}")
	public ResponseEntity<ApiResponse<Integer>>deleteBook(@PathVariable Integer bookId){
		bookService.deleteBook(bookId);
		return ResponseEntity.ok(ApiResponse.success("書籍刪除成功", bookId));
	}
	
	@ExceptionHandler({BookException.class})
	public ResponseEntity<ApiResponse<Void>>handleBookExceptions(BookException e){
		return ResponseEntity.status(500).body(ApiResponse.error(500, e.getMessage()));
	}
	

=======
public class BookRestController {

	
>>>>>>> 44fc16ad4de7b3a3fd2a0beba4b2799ac9685679
}
