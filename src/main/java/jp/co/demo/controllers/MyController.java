package jp.co.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import jp.co.demo.entities.MyData;
import jp.co.demo.services.MyService;

@RestController
@RequestMapping("/api/user")
public class MyController {

    @Autowired
    MyService myService;

// ID指定検索（1件検索）
    @RequestMapping(method=RequestMethod.GET, value="{id}")
    public Optional<MyData> getUser(@PathVariable("id") Long id) {
        System.out.println("api called -getUser");
        return myService.findUser(id);
    }

// 全件検索
    @RequestMapping(method = RequestMethod.GET)
    public List<MyData> getUsers() {
        System.out.println("api called -getUsers");
        return myService.findUsers();
    }

// 登録
    @RequestMapping(method=RequestMethod.POST)
    public MyData createUser(@Validated @RequestBody MyData user) {
        System.out.println("api called -createUser");
        return myService.save(user);
    }
// 更新
    @RequestMapping(method=RequestMethod.PUT, value="{id}")
    public MyData updateUser(@PathVariable("id") Long id, @RequestBody MyData user) {
        System.out.println("api called -updateUser");
        user.setId(id);
        return myService.save(user);
    }

// ID指定削除（1件削除）
    @RequestMapping(method=RequestMethod.DELETE, value="{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        System.out.println("api called -deleteUser");
        myService.deleteUser(id);
        String msg = "ID:" + id.toString() + " " +  "is deleted.";
        return msg;
    }

 // 全件削除
    @RequestMapping(method=RequestMethod.DELETE)
    public String deleteUsers() {
        System.out.println("api called -deleteUsers");
        myService.deleteUsers();
        String msg = "all... deleted..";
        return msg;
    }

}