/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package web;

/**
 *
 * @author Rick
 */
public class PessoaNomeIdadeDto {

    private String nome;
    private Short idade;

    public PessoaNomeIdadeDto() {
    }

    public PessoaNomeIdadeDto(String nome, Short idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Short getIdade() {
        return idade;
    }

    public void setIdade(Short idade) {
        this.idade = idade;
    }
}
