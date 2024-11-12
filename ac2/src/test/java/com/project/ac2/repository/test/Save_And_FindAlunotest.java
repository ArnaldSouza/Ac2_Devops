package com.project.ac2.repository.test;

import java.util.Optional;

import org.junit.jupiter.api.Test;
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
public class Save_And_FindAlunotest {
	@Autowired
    private Aluno_Repository alunoRepository;

    @Test
    public void testSave_And_Find_User() {
        // Cria um novo aluno
        Aluno aluno = new Aluno();
        aluno.setnomeAluno("Aluno 2 test");

        // Salva no banco de dados
        Aluno alunoSalvo = alunoRepository.save(aluno);
        assertNotNull(alunoSalvo.getId());
        // Busca o usuário pelo ID
        Optional<Aluno> alunoBD = alunoRepository.findById(alunoSalvo.getId());
        assertThat(alunoBD).isPresent();
        assertThat(alunoBD.get().getnomeAluno()).isEqualTo("Aluno 2 test");
    }
}
