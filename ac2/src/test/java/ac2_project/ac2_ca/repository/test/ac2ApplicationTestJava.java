package ac2_project.ac2_ca.repository.test;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

import com.project.ac2.entity.*;
import com.project.ac2.repository.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
 class Save_And_Find_AlunoTest{
	@Autowired
    private Aluno_Repository alunoRepository;

	
    @Test
    public void testSaveAndFindAluno() {
    	// Cria um novo aluno
    	Aluno aluno = new Aluno();
        aluno.setnomeAluno("testUser1");

        // Salva no banco de dados
        Aluno savedUser = alunoRepository.save(aluno);
        assertNotNull(savedUser.getId());
        // Busca o usuário pelo ID
        Optional<Aluno> retrievedUser = alunoRepository.findById(savedUser.getId());
        assertThat(retrievedUser).isPresent();
        assertThat(retrievedUser.get().getnomeAluno()).isEqualTo("testUser1");

    }
}

@SpringBootTest
class Ac2ApplicationTests {

	@Autowired
    private Aluno_Repository alunoRepository;

    @Test
    void testSaveAndFindUser() {
        //Cria um objeto User com um email válido
        Aluno user = new Aluno();
        user.setnomeAluno("testUser");
        user.setCpf(new Cpf("123.122.222-66"));

         //Salva no banco de dados
        Aluno savedUser = alunoRepository.save(user);
        assertNotNull(savedUser.getId());  // Verifica se o ID foi gerado

        // Busca o usuário pelo ID
        Optional<Aluno> retrievedUser = alunoRepository.findById(savedUser.getId());
        assertTrue(retrievedUser.isPresent());
        assertEquals("testUser", retrievedUser.get().getnomeAluno());
   }


}
