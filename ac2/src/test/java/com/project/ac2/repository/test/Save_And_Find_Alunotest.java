package com.project.ac2.repository.test;

import java.util.Optional;


import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.project.ac2.entity.Aluno;
import com.project.ac2.repository.Aluno_Repository;


@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@DataJpaTest
public class Save_And_Find_Alunotest {
	
	@Autowired
	private Aluno_Repository alunoRepository;
	
	public void testeSaveAndFindAluno() {
		
		//Cria um novo Aluno
		Aluno aluno = new Aluno();
		aluno.setnomeAluno("Teste");
		
		//Salva no banco de dados
		Aluno alunoSalvo = alunoRepository.save(aluno);
		assertNotNull(alunoSalvo.getId()); //verifica se o Id não está nulo
		
		//Busca o aluno pelo Id
		Optional<Aluno> alunoBD = alunoRepository.findById(alunoSalvo.getId());
		assertThat(alunoBD).isPresent();
		assertThat(alunoBD.get().getnomeAluno()).isEqualTo("Teste");
		
	}
}
