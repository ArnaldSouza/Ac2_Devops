package com.project.ac2.entity;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "tb_aluno")
public class Aluno {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
 
    
    private String nomeAluno;
    
    public String getnomeAluno() {
        return nomeAluno;
    }

    public void setnomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }

    @Embedded
    private Cpf cpf;
    
    public Cpf getCpf() {
        return cpf;
    }

    public void setCpf(Cpf cpf) {
        this.cpf = cpf;
    }
    
    @Embedded
    private Media media;
    
    public Media getMedia() {
        return media;
    }

    public void setMedia(Media media) {
        this.media = media;
    }
}
