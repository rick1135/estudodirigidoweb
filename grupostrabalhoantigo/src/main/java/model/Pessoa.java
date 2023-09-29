/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

/**
 *
 * @author Rick
 */
@Entity
@NamedQuery(name = "Pessoa.findAll", query = "SELECT p FROM Pessoa p")
@NamedQuery(name = "Pessoa.findNomes", query = "SELECT p.nome FROM Pessoa p")
@NamedQuery(name = "Pessoa.findPessoasEnderecos", query = "SELECT p.nome, e FROM Pessoa p JOIN p.endereco e")
@NamedQuery(name = "Pessoa.porTipoLogradouro", query = "SELECT p FROM Pessoa p JOIN p.endereco e WHERE e.tipoLogradouro = :tipoLogradouro")
public class Pessoa implements Serializable {
    public Pessoa() {
        telefones = new ArrayList<>();
        atuacoes = new ArrayList<>();
        lideranca = new ArrayList<>();
    }

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 65, nullable = false)
    private String nome;

    @Column(length = 250, nullable = false)
    private String email;

    @Column(columnDefinition = "DATE")
    private LocalDate dataNascimento;

    @Transient
    private Short idade;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private Endereco endereco;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "pessoa")
    private List<Telefone> telefones;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Grupo> lideranca;    
    
    @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Atuacao> atuacoes;

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
        this.idade = (short) (LocalDate.now().getYear() - this.dataNascimento.getYear());
    }

    public Short getIdade() {
        return idade;
    }

    public List<Grupo> getLideranca() {
        return lideranca;
    }

    public void setLideranca(List<Grupo> lideranca) {
        this.lideranca = lideranca;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<Atuacao> getAtuacoes() {
        return atuacoes;
    }

    public void setAtuacoes(List<Atuacao> atuacoes) {
        this.atuacoes = atuacoes;
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }

    // HashCode, Equals e ToString
    @Override
    public int hashCode() {
        return Objects.hash(id, nome, email, dataNascimento, idade);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Pessoa pessoa = (Pessoa) o;
        return Objects.equals(id, pessoa.id);
    }

    @Override
    public String toString() {
        return "Pessoa{" + "id=" + id + ", nome=" + nome + ", email=" + email + ", dataNascimento=" + dataNascimento + ", idade=" + idade + ", lideranca=" + lideranca + ", atuacoes=" + atuacoes + ", endereco=" + endereco + ", telefones=" + telefones + '}';
    }

}
