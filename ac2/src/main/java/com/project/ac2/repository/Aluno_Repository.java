package com.project.ac2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.ac2.entity.Aluno;

@Repository
public interface Aluno_Repository extends JpaRepository<Aluno, Long>{

}
