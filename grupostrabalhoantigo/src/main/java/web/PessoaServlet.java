/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Atuacao;
import model.Endereco;
import model.Grupo;
import model.Pessoa;
import model.Telefone;

/**
 *
 * @author Rick
 */
@WebServlet(urlPatterns = {"/pessoaservlet"})
public class PessoaServlet extends HttpServlet {

    @Inject
    private PessoaServiceLocal pessoaService;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        // Enderecos
        Endereco e1 = new Endereco();
        e1.setTipoLogradouro(Endereco.TipoLogradouro.RUA);
        e1.setLogradouro("Rua 1");
        e1.setBairro("Humberto");
        e1.setNumero(111);

        Endereco e2 = new Endereco();
        e2.setTipoLogradouro(Endereco.TipoLogradouro.AVENIDA);
        e2.setLogradouro("Avenida 2");
        e2.setBairro("Doisberto");
        e2.setNumero(2222);

        Endereco e3 = new Endereco();
        e3.setTipoLogradouro(Endereco.TipoLogradouro.AVENIDA);
        e3.setLogradouro("Avenida 3");
        e3.setBairro("Trêsberto");
        e3.setNumero(3333);

        Endereco e4 = new Endereco();
        e4.setTipoLogradouro(Endereco.TipoLogradouro.PRACA);
        e4.setLogradouro("Praca 4");
        e4.setBairro("Quatroberto");
        e4.setNumero(4444);

        // Telefones
        Telefone t1 = new Telefone();
        t1.setDdd((byte) 11);
        t1.setNumero(11111111);

        Telefone t2 = new Telefone();
        t2.setDdd((byte) 12);
        t2.setNumero(12121212);

        Telefone t3 = new Telefone();
        t3.setDdd((byte) 13);
        t3.setNumero(13131313);

        Telefone t4 = new Telefone();
        t4.setDdd((byte) 22);
        t4.setNumero(2222222);

        Telefone t5 = new Telefone();

        Telefone t6 = new Telefone();
        t6.setDdd((byte) 44);
        t6.setNumero(4444444);

        Telefone t7 = new Telefone();
        t7.setDdd((byte) 45);
        t7.setNumero(45454545);

        // Grupos
        Grupo grupo1 = new Grupo();
        grupo1.setNome("Estudo I");
        grupo1.setAtivo(false);

        Grupo grupo2 = new Grupo();
        grupo2.setNome("Estudo II");
        grupo2.setAtivo(true);

        Grupo grupo3 = new Grupo();
        grupo3.setNome("Estudo III");
        grupo3.setAtivo(false);

        Grupo grupo4 = new Grupo();
        grupo4.setNome("Estudo IV");
        grupo4.setAtivo(true);

        // Atuacoes
        LocalDate dataInicio1 = LocalDate.of(2011, 1, 1);
        LocalDate dataTermino1 = LocalDate.of(2021, 11, 11);

        LocalDate dataInicio2 = LocalDate.of(2012, 1, 1);
        LocalDate dataTermino2 = null; // Data de término indefinida

        LocalDate dataInicio3 = LocalDate.of(2013, 1, 1);
        LocalDate dataTermino3 = LocalDate.of(2023, 1, 13);

        LocalDate dataInicio4 = LocalDate.of(2014, 1, 4);
        LocalDate dataTermino4 = LocalDate.of(2024, 1, 14);

        //Pessoas
        Pessoa anaZaira = new Pessoa();
        anaZaira.setNome("Ana Zaira");
        anaZaira.setEmail("ana@mail.com");
        anaZaira.setDataNascimento(LocalDate.of(2001, 1, 1));
        anaZaira.setEndereco(e1);
        anaZaira.getTelefones().add(t1);
        anaZaira.getTelefones().add(t2);
        anaZaira.getTelefones().add(t3);

        Pessoa beatrizYana = new Pessoa();
        beatrizYana.setNome("Beatriz Yana");
        beatrizYana.setEmail("beatriz@mail.com");
        beatrizYana.setDataNascimento(LocalDate.of(2002, 2, 2));
        beatrizYana.setEndereco(e2);
        beatrizYana.getTelefones().add(t4);

        Pessoa ceciliaXerxes = new Pessoa();
        ceciliaXerxes.setNome("Cecília Xerxes");
        ceciliaXerxes.setEmail("cecilia@mail.com");
        ceciliaXerxes.setDataNascimento(LocalDate.of(2003, 3, 3));
        ceciliaXerxes.setEndereco(e3);

        Pessoa deboraWendel = new Pessoa();
        deboraWendel.setNome("Débora Wendel");
        deboraWendel.setEmail("debora@mail.com");
        deboraWendel.setDataNascimento(LocalDate.of(2004, 4, 4));
        deboraWendel.setEndereco(e4);
        deboraWendel.getTelefones().add(t6);
        deboraWendel.getTelefones().add(t7);

        // Liderancas
        anaZaira.getLideranca().add(grupo1);
        beatrizYana.getLideranca().add(grupo2);
        ceciliaXerxes.getLideranca().add(grupo3);
        beatrizYana.getLideranca().add(grupo4);
        
        //Atuacoes
        Atuacao atuacao1 = new Atuacao();
        atuacao1.setPessoa(anaZaira);
        atuacao1.setGrupo(grupo1);
        atuacao1.setInicio(dataInicio1);
        atuacao1.setTermino(dataTermino1);

        Atuacao atuacao2 = new Atuacao();
        atuacao2.setPessoa(beatrizYana);
        atuacao2.setGrupo(grupo2);
        atuacao2.setInicio(dataInicio2);
        atuacao2.setTermino(dataTermino2);

        Atuacao atuacao3 = new Atuacao();
        atuacao3.setPessoa(ceciliaXerxes);
        atuacao3.setGrupo(grupo3);
        atuacao3.setInicio(dataInicio3);
        atuacao3.setTermino(dataTermino3);

        Atuacao atuacao4 = new Atuacao();
        atuacao4.setPessoa(beatrizYana);
        atuacao4.setGrupo(grupo4);
        atuacao4.setInicio(dataInicio4);
        atuacao4.setTermino(dataTermino4);

        // Salvamento via beans de sessão
        pessoaService.salvar(anaZaira);
        pessoaService.salvar(beatrizYana);
        pessoaService.salvar(ceciliaXerxes);
        pessoaService.salvar(deboraWendel);
        try (PrintWriter out = response.getWriter()) {

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Inserir Dados</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Dados inseridos com sucesso!</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
