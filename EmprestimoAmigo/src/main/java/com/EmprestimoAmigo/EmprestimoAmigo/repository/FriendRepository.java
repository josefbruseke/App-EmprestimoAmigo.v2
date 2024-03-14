package com.EmprestimoAmigo.EmprestimoAmigo.repository;

import com.EmprestimoAmigo.EmprestimoAmigo.models.Friend;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface FriendRepository extends JpaRepository<Friend, Long> {
    Optional<Friend> findByName(String url);
}
