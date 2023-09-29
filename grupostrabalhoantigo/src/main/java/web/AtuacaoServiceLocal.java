/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package web;

import java.util.List;
import javax.ejb.Local;
import model.Atuacao;
import model.Grupo;
import model.Pessoa;

/**
 *
 * @author Rick
 */
@Local
public interface AtuacaoServiceLocal {

    void salvar(Atuacao atuacao);

    List<Atuacao> buscarAtuacoesPorPessoa(Pessoa pessoa);

    List<Atuacao> buscarAtuacoesPorGrupo(Grupo grupo);

    List<Pessoa> buscarMembrosPorLider(Pessoa lider);

    List<Pessoa> buscarLideresPorMembro(Pessoa membro);
}