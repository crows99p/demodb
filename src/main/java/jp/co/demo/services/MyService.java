package jp.co.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.demo.entities.MyData;
import jp.co.demo.repositories.MyRepository;

@Service
@Transactional
public class MyService {

    @Autowired
    MyRepository myRepository;

// ID指定検索（1件検索）
    public Optional<MyData> findUser(Long id){
        return myRepository.findById(id);
    }

// 全件検索
    public List<MyData> findUsers(){
        return myRepository.findAll();
    }

// 登録（更新）
    public MyData save(MyData user) {
        return myRepository.save(user);
    }

 // ID指定削除（1件削除）
    public void deleteUser(Long id) {
        myRepository.deleteById(id);
    }

// 全件削除
    public void deleteUsers() {
        myRepository.deleteAll();
    }
}
