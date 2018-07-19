package jp.co.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jp.co.demo.entities.MyData;

@Repository
public interface MyRepository extends JpaRepository<MyData, Long> {
}


