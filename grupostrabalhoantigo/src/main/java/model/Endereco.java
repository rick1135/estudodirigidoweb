/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Rick
 */
@Entity
public class Endereco implements Serializable {
    
    public enum TipoLogradouro {
        RUA, AVENIDA, PRACA, OUTRO;
    }
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "tipoLogradouro")
    @Enumerated(EnumType.STRING)
    private TipoLogradouro tipoLogradouro;
    
    @Column(length = 150)
    private String logradouro;
    
    @Column
    private int numero;
    
    @Column(length = 25)
    private String bairro;

    @ManyToOne
    private Pessoa pessoa;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TipoLogradouro getTipoLogradouro() {
        return tipoLogradouro;
    }

    public void setTipoLogradouro(TipoLogradouro tipoLogradouro) {
        this.tipoLogradouro = tipoLogradouro;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    

    // HashCode, Equals e ToString
    @Override
    public int hashCode() {
        return Objects.hash(id, tipoLogradouro, numero, bairro);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Endereco endereco = (Endereco) o;
        return Objects.equals(id, endereco.id);
    }

    @Override
    public String toString() {
        return "Endereco{" + "id=" + id + ","
                + " tipoLogradouro=" + tipoLogradouro + ","
                + " logradouro=" + logradouro + ","
                + " numero=" + numero + ","
                + " bairro=" + bairro + ","
                + " pessoa=" + pessoa + '}';
    }    
}