package com.project.ac2.entity;

import java.util.Objects;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class Media {

    private Double Aluno_media;
    
    protected Media() {}

    public Media(Double Aluno_media) {
        if (Aluno_media == null) {
            throw new IllegalArgumentException("Média inválida");
        }else if(Aluno_media < 0 || Aluno_media > 10){
        	throw new IllegalArgumentException("A média deve estar entre 0 e 10");
        }
        this.Aluno_media = Aluno_media;
    }

    public Double getUserMedia() {
        return Aluno_media;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Media media = (Media) o;
        return Objects.equals(Aluno_media, media.Aluno_media);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Aluno_media);
    }

	
}