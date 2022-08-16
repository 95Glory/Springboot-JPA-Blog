package com.example.metablog.repository;

import com.example.metablog.model.Board;
import com.example.metablog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BoardRepository extends JpaRepository<Board,Integer> {

}
