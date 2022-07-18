package com.CamperLand.CT.controller;



import com.CamperLand.CT.logic.User;
import com.CamperLand.CT.logic.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/users")
public class UserRestController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserInfo(@PathVariable String id){
        User user = userService.userInfo(id);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }


}

