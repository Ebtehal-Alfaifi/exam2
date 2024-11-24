package com.example.exam.Controller;

import com.example.exam.ApiResponse.Api;
import com.example.exam.Model.UserModel;
import com.example.exam.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    //get users
    @GetMapping("/get")
    public ResponseEntity getALL(){
        ArrayList<UserModel>getall=userService.getAll();
        return ResponseEntity.status(200).body(getall);
    }


    //add new
    @PostMapping("/add")
    public ResponseEntity addNew(@RequestBody @Valid UserModel userModel, Errors errors){
        if (errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }

        userService.addNew(userModel);
        return ResponseEntity.status(200).body(new Api(" add success"));
    }

    //update
    @PutMapping("/update/{id}")
    public ResponseEntity update(@PathVariable String id,@RequestBody @Valid UserModel userModel,Errors errors){
        if (errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean check=userService.updateUseers(id,userModel);
if (check){
    return ResponseEntity.status(200).body(new Api(" update success"));
}
return ResponseEntity.status(400).body(new Api(" id not found"));
    }

    //delete
    @DeleteMapping("/delete/{id}")

    public ResponseEntity delete(@PathVariable String id){
        boolean check=userService.delete(id);
        if (check){
            return ResponseEntity.status(200).body(new Api("delete success"));
        }
        return ResponseEntity.status(400).body(new Api(" id not found"));

    }

    @GetMapping("/get_balance/{balance}")
public ResponseEntity getByBalanc(@PathVariable int balance){
        ArrayList<UserModel>getBalance=userService.getByBalence(balance);
        if (getBalance!=null){
            return ResponseEntity.status(200).body(getBalance);
        }
        return ResponseEntity.status(400).body(new Api(" there is no user in that balance"));

}

//get by age
    @GetMapping("/age_range/{id}")
    public ResponseEntity getByage(@PathVariable int age){
        ArrayList<UserModel>ageRange=userService.getByAge(age);
        if (ageRange!=null){
            return ResponseEntity.status(200).body(ageRange);
        }
        return ResponseEntity.status(400).body(new Api(" there is no users in that range"));

    }



}
