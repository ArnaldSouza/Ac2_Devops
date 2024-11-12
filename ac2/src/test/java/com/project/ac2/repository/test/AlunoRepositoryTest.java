package com.project.ac2.repository.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import org.springframework.test.context.ActiveProfiles;

import com.project.ac2.entity.Aluno;
import com.project.ac2.entity.Cpf;
import com.project.ac2.entity.Media;
import com.project.ac2.repository.Aluno_Repository;

@ActiveProfiles("test")
@DataJpaTest
public class AlunoRepositoryTest {
	
	@Autowired
	private Aluno_Repository alunoRepository;
	
	@Test
	void testSaveAndFindAluno() {
		
		//criando um novo Aluno com cpf e média válida
		Aluno aluno = new Aluno();
		aluno.setnomeAluno("Aluno");
		aluno.setCpf(new Cpf("123.456.789-10"));
		aluno.setMedia(new Media(8.5));
		
		//salvando o usuário no banco de dados
		Aluno savedAluno = alunoRepository.save(aluno);
		assertNotNull(savedAluno.getId());
		
		//buscando o usuário pelo ID
		Optional<Aluno> alunoBD = alunoRepository.findById(savedAluno.getId());
		assertTrue(alunoBD.isPresent());
		assertEquals("Aluno", alunoBD.get().getnomeAluno());
	}
	
}
