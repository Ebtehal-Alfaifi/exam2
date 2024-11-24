package com.example.exam.Controller;

import com.example.exam.ApiResponse.Api;
import com.example.exam.Model.BookModel;
import com.example.exam.Service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/book")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    // getAll book
    @GetMapping("/get")
public ResponseEntity getAll(){
    ArrayList<BookModel>list=bookService.getAll();
    return ResponseEntity.status(200).body(list);
}

//add new
@PostMapping("/add")
public ResponseEntity addNew(@RequestBody @Valid BookModel bookModel, Errors errors){
        if (errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        bookService.addNew(bookModel);
        return ResponseEntity.status(200).body(new Api(" add success"));

}

//update
@PutMapping("/update/{id}")
public ResponseEntity update(@PathVariable String id,@RequestBody @Valid BookModel bookModel,Errors errors){
        if (errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        bookService.updatebook(id,bookModel);
        return ResponseEntity.status(200).body(new Api(" add success"));

}

//delete
@DeleteMapping("/delete/{id}")
public ResponseEntity delete(@PathVariable String id){
        boolean isFounded=bookService.delete(id);
        if (isFounded){
            return ResponseEntity.status(200).body(new Api(" delete success"));
        }
        return ResponseEntity.status(400).body(new Api(" id not founded"));

}




//getBook by name
    @GetMapping("/get_book/{name}")
    public ResponseEntity getBookName(@PathVariable String name){
        BookModel bookModel=bookService.getByName(name);
        if (bookModel!=null){
            return ResponseEntity.status(200).body(bookModel);
        }
        return ResponseEntity.status(400).body(new Api(" name not found"));

    }



//get by category
    @GetMapping("/get_by_category/{category}")
    public ResponseEntity getByCategory(@PathVariable String category){
        ArrayList<BookModel>model=bookService.getCategory(category);
       if (model!=null){
           return ResponseEntity.status(200).body(model);
       }
       return ResponseEntity.status(400).body(new Api(" category does not found"));

    }
    //get book by page number
@GetMapping("/get_number/{number}")
    public ResponseEntity getBynumber(@PathVariable int number){
        ArrayList<BookModel>bookModels=bookService.getNumber(number);
        if (bookModels!=null){
            return ResponseEntity.status(200).body(bookModels);
        }
        return ResponseEntity.status(400).body(new Api("the books do not found  "));
    }





}
