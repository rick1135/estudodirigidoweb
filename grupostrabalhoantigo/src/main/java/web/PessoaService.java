/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package web;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import model.Atuacao;
import model.Endereco;
import model.Endereco.TipoLogradouro;
import model.Pessoa;
import model.PessoaEnderecoDTO;
import model.Telefone;

/**
 *
 * @author Rick
 */
@Stateless
public class PessoaService implements PessoaServiceLocal {

    @PersistenceContext
    private EntityManager em;

    //Salvar e buscar
    @Override
    public void salvar(Pessoa pessoa) {
        em.persist(pessoa);
    }

    @Override
    public Pessoa buscar(Long id) {
        return em.find(Pessoa.class, id);
    }

    //Consultas 01
    @Override
    public List<Pessoa> buscarTodasPessoasPorQuery() {
        TypedQuery<Pessoa> query = em.createQuery("SELECT p FROM Pessoa p", Pessoa.class);
        return query.getResultList();
    }

    @Override
    public List<Pessoa> buscarTodasPessoasPorTypedQuery() {
        TypedQuery<Pessoa> query = em.createQuery("SELECT p FROM Pessoa p", Pessoa.class);
        return query.getResultList();
    }

    @Override
    public List<Pessoa> buscarTodasPessoasPorNamedQuery() {
        return em.createNamedQuery("Pessoa.findAll", Pessoa.class).getResultList();
    }

    @Override
    public List<Pessoa> buscarTodasPessoas() {
        Query q = em.createQuery("SELECT p FROM Pessoa p");
        return (List<Pessoa>) q.getResultList();
    }

    //Consultas 02
    @Override
    public List<String> buscarNomesPorQuery() {
        TypedQuery<String> query = em.createQuery("SELECT p.nome FROM Pessoa p", String.class);
        return query.getResultList();
    }

    @Override
    public List<String> buscarNomesPorTypedQuery() {
        TypedQuery<String> query = em.createQuery("SELECT p.nome FROM Pessoa p", String.class);
        return query.getResultList();
    }

    @Override
    public List<String> buscarNomesPorNamedQuery() {
        return em.createNamedQuery("Pessoa.findNomes", String.class).getResultList();
    }

    //cONSULTAS 03
    @Override
    public List<PessoaEnderecoDTO> buscarPessoasEnderecosPorQuery() {
        TypedQuery<Object[]> query = em.createQuery(
                "SELECT p.nome, e FROM Pessoa p JOIN p.endereco e", Object[].class);
        List<Object[]> results = query.getResultList();

        return mapToPessoaEnderecoDTOList(results);
    }

    @Override
    public List<PessoaEnderecoDTO> buscarPessoasEnderecosPorTypedQuery() {
        TypedQuery<Object[]> query = em.createQuery(
                "SELECT p.nome, e FROM Pessoa p JOIN p.endereco e", Object[].class);
        List<Object[]> results = query.getResultList();

        return mapToPessoaEnderecoDTOList(results);
    }

    @Override
    public List<PessoaEnderecoDTO> buscarPessoasEnderecosPorNamedQuery() {
        TypedQuery<Object[]> query = em.createNamedQuery(
                "Pessoa.findPessoasEnderecos", Object[].class);
        List<Object[]> results = query.getResultList();

        return mapToPessoaEnderecoDTOList(results);
    }

    private List<PessoaEnderecoDTO> mapToPessoaEnderecoDTOList(List<Object[]> results) {
        List<PessoaEnderecoDTO> dtos = new ArrayList<>();
        for (Object[] result : results) {
            String nome = (String) result[0];
            Endereco endereco = (Endereco) result[1];

            PessoaEnderecoDTO dto = new PessoaEnderecoDTO(nome, endereco);
            dtos.add(dto);
        }
        return dtos;
    }

    @Override
    public List<Pessoa> buscarPessoasQueMoramEmAvenidasPorQuery() {
    String queryString = "SELECT p FROM Pessoa p JOIN p.endereco e WHERE e.tipoLogradouro = :tipoLogradouro";
    Query query = em.createQuery(queryString, Pessoa.class);
    query.setParameter("tipoLogradouro", TipoLogradouro.AVENIDA);
    return query.getResultList();
}

    @Override
    public List<Pessoa> buscarPessoasQueMoramEmAvenidasPorTypedQuery() {
    String queryString = "SELECT p FROM Pessoa p JOIN p.endereco e WHERE e.tipoLogradouro = :tipoLogradouro";
    TypedQuery<Pessoa> query = em.createQuery(queryString, Pessoa.class);
    query.setParameter("tipoLogradouro", TipoLogradouro.AVENIDA);
    return query.getResultList();
}

    @Override
    public List<Pessoa> buscarPessoasQueMoramEmAvenidasPorNamedQuery() {
    return em.createNamedQuery("Pessoa.porTipoLogradouro", Pessoa.class)
            .setParameter("tipoLogradouro", TipoLogradouro.AVENIDA)
            .getResultList();
}

}
