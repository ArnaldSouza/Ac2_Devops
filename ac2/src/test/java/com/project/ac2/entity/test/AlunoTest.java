package com.project.ac2.entity.test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.project.ac2.entity.Aluno;
import com.project.ac2.entity.Cpf;
import com.project.ac2.entity.Media;

public class AlunoTest {	
	
	
	@Test
    void testSetAndGetValidCpf() {
        Aluno aluno = new Aluno();
        Cpf cpf = new Cpf("123.456.789-10");
        aluno.setCpf(cpf);
        
        assertEquals(cpf, aluno.getCpf());
    }
	
	@Test
    void testInvalidCpfThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Cpf("invalid-cpf");
        });
    }

	
	

}
