package com.project.ac2.entity;

import java.util.Objects;
import jakarta.persistence.Embeddable;
import lombok.Data;


@Embeddable
@Data
public class Cpf {
	
	private String Aluno_Cpf;
	
	protected Cpf() {}
	
	public Cpf(String Aluno_Cpf) {
        if (Aluno_Cpf == null || !Aluno_Cpf.matches("^\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}$")) {
            throw new IllegalArgumentException("CPF inválido");
        }
        this.Aluno_Cpf = Aluno_Cpf;
    }

    public String getUserCpf() {
        return Aluno_Cpf;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cpf cpf = (Cpf) o;
        return Objects.equals(Aluno_Cpf, cpf.Aluno_Cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Aluno_Cpf);
    }
}
