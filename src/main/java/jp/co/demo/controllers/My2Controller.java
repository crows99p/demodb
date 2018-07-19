package jp.co.demo.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import jp.co.demo.entities.My2Data;
import jp.co.demo.services.My2Service;

@RestController
@RequestMapping("/api/user2")
public class My2Controller {

    @Autowired
    My2Service myService;

// ID指定検索（1件検索）
    @RequestMapping(method=RequestMethod.GET, value="{id}")
    public List<Map<String, Object>> getUser(@PathVariable("id") Long id) {
        System.out.println("api called -getUser");
        return myService.findUser(id);
    }

// 全件検索
    @RequestMapping(method = RequestMethod.GET)
    public List<My2Data> getUsers() {
        System.out.println("api called -getUsers");
        return myService.findUsers();
    }

// 登録
    @RequestMapping(method=RequestMethod.POST)
    public My2Data createUser(@Validated @RequestBody My2Data user) {
        System.out.println("api called -createUser");
        return myService.save(user);
    }
// 更新
    @RequestMapping(method=RequestMethod.PUT, value="{id}")
    public My2Data updateUser(@PathVariable("id") Long id, @RequestBody My2Data user) {
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