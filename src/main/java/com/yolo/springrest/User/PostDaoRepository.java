package com.yolo.springrest.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostDaoRepository extends JpaRepository<Post, Integer>{

} 