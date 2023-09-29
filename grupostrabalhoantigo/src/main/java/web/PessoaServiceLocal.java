/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package web;

import java.util.List;
import javax.ejb.Local;
import model.Pessoa;
import model.PessoaEnderecoDTO;
import model.Telefone;

/**
 *
 * @author Rick
 */
@Local
public interface PessoaServiceLocal {

    void salvar(Pessoa pessoa);

    Pessoa buscar(Long id);

    List<Pessoa> buscarTodasPessoasPorQuery();

    List<Pessoa> buscarTodasPessoasPorTypedQuery();

    List<Pessoa> buscarTodasPessoasPorNamedQuery();

    List<Pessoa> buscarTodasPessoas();

    List<String> buscarNomesPorQuery();

    List<String> buscarNomesPorTypedQuery();

    List<String> buscarNomesPorNamedQuery();
   
    List<PessoaEnderecoDTO> buscarPessoasEnderecosPorQuery();

    List<PessoaEnderecoDTO> buscarPessoasEnderecosPorTypedQuery();

    List<PessoaEnderecoDTO> buscarPessoasEnderecosPorNamedQuery();
    
    List<Pessoa> buscarPessoasQueMoramEmAvenidasPorQuery();
    
    List<Pessoa> buscarPessoasQueMoramEmAvenidasPorTypedQuery();
    
    List<Pessoa> buscarPessoasQueMoramEmAvenidasPorNamedQuery();

}
