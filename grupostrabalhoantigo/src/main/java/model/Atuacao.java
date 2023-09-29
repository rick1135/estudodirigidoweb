/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 *
 * @author Rick
 */
@Entity
public class Atuacao implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(columnDefinition = "DATE")
    private LocalDate inicio;
    
    @Column(columnDefinition = "DATE")
    private LocalDate termino;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "pessoa_id")
    @JsonbTransient
    private Pessoa pessoa;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "grupo_id")
    @JsonbTransient
    private Grupo grupo;
    
    //<editor-fold defaultstate="collapsed" desc="Getters/Setters">
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getInicio() {
        return inicio;
    }

    public void setInicio(LocalDate inicio) {
        this.inicio = inicio;
    }

    public LocalDate getTermino() {
        return termino;
    }

    public void setTermino(LocalDate termino) {
        this.termino = termino;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Grupo getGrupo() {
        return grupo;
    }
    
    public void setGrupo(Grupo grupo) {    
        this.grupo = grupo;
    }

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="hashCode/equals/toString">
    @Override
    public int hashCode() {
        return Objects.hash(id, inicio, termino);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Atuacao atuacao = (Atuacao) o;
        return Objects.equals(id, atuacao.id);
    }

    @Override
    public String toString() {
        return "Atuacao{" + "id=" + id + ","
                + " inicio=" + inicio + ","
                + " termino=" + termino + ","
                + " pessoa=" + pessoa + ","
                + " grupo=" + grupo + '}';
    }
    //</editor-fold>    
}
