package com.project.ac2.repository.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.project.ac2.entity.Aluno;
import com.project.ac2.entity.Cpf;
import com.project.ac2.entity.Media;
import com.project.ac2.repository.Aluno_Repository;

@ActiveProfiles("test")
@DataJpaTest
public class AlunoRespositoryTest {
	
	@Autowired
	private Aluno_Repository alunoRepository;
	
	@Test
	public void testSaveandFindAluno(){
		
		//cria um aluno com cpf e media válida
		Aluno aluno = new Aluno();
		aluno.setnomeAluno("Aluno 1 test");
		aluno.setCpf(new Cpf("485.235.548-15"));
		aluno.setMedia(new Media(7.5));
		
		//salva o objeto no banco de dados
		Aluno alunoSalvo = alunoRepository.save(aluno);
		assertNotNull(alunoSalvo.getId());
		
		//busca pelo aluno pelo ID
		Optional<Aluno> alunoBd = alunoRepository.findById(alunoSalvo.getId());
	    assertTrue(alunoBd.isPresent());
	    assertEquals("Aluno 1 test", alunoBd.get().getnomeAluno());
		
	}
}
