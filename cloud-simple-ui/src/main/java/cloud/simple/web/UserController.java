/**
 * @(#)UserController.java, 十月 28, 2016.
 * <p>
 * Copyright 2016 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package cloud.simple.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cloud.simple.data.User;
import cloud.simple.service.UserService;

/**
 * @author zhangpeng
 */
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value="/users")
    public ResponseEntity<List<User>> readUserInfo(){
        List<User> users=userService.readUserInfo();
        User user = new User();
        user.setId(123);user.setUsername("pandora");
        users.add(user);
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }
    
    @RequestMapping(value="/userFirst")
    public ResponseEntity<User> readUserInfoFirst(){
        List<User> users=userService.readUserInfo();
        //User use = users.get(0);//java.util.LinkedHashMap cannot be cast to cloud.simple.data.User User实现Serializable接口解决不了这个问题
        User user = new User();
        try{
          //System.out.println(users.get(0).getClass().getName());
            System.out.println(users.get(0).toString());
            user.setId(users.get(0).getId());user.setUsername(users.get(0).getUsername());
        }catch(Exception e){
            e.printStackTrace();
        }
        
        user.setId(123);user.setUsername("pandora");
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }
}