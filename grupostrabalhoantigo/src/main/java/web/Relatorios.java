/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.inject.Inject;
import util.Util;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

/**
 *
 * @author Rick
 */
@Transactional
@WebServlet(name = "Relatorios", urlPatterns = {"/relatorios"})
public class Relatorios extends HttpServlet {

    @Inject
    private PessoaServiceLocal PessoaService;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Relatórios</title>");
        out.println("</head>");
        out.println("<body>");

        // Consulta 01a - Quais as pessoas (dados completos) cadastradas? Por meio de Query
        out.println("<h2>Consulta 01a -Quais as pessoas (dados completos) cadastradas? Por meio de Query</h2>");
        out.println("<pre>");
        out.println(Util.toJson(PessoaService.buscarTodasPessoas()) + "</pre></p>");
        out.println("</pre>");

        // Consulta 01b - Quais as pessoas (dados completos) cadastradas? Por meio de TypedQuery
        out.println("<h2>Consulta 01b - Quais as pessoas (dados completos) cadastradas? Por meio de TypedQuery</h2>");
        out.println("<pre>");
        out.println(Util.toJson(PessoaService.buscarTodasPessoasPorTypedQuery()) + "</pre></p>");
        out.println("</pre>");

        // Consulta 01c - Quais as pessoas (dados completos) cadastradas? Por meio de NamedQuery
        out.println("<h2>Consulta 01c - Quais as pessoas (dados completos) cadastradas? Por meio de NamedQuery</h2>");
        out.println("<pre>");
        out.println(Util.toJson(PessoaService.buscarTodasPessoasPorNamedQuery()) + "</pre></p>");
        out.println("</pre>");

        // Consulta 02a - Quais os nomes das pessoas? Por meio de Query
        out.println("<h2>Consulta 02a - Quais os nomes das pessoas? Por meio de Query</h2>");
        out.println("<pre>");
        out.println(Util.toJson(PessoaService.buscarNomesPorQuery()) + "</pre></p>");
        out.println("</pre>");

        // Consulta 02b - Quais os nomes das pessoas?  Por meio de TypedQuery
        out.println("<h2>Consulta 02b - Quais os nomes das pessoas? Por meio de TypedQuery</h2>");
        out.println("<pre>");
        out.println(Util.toJson(PessoaService.buscarNomesPorTypedQuery()) + "</pre></p>");
        out.println("</pre>");

        // Consulta 02c - Quais os nomes das pessoas?  Por meio de NamedQuery
        out.println("<h2>Consulta 02c - Quais os nomes das pessoas? Por meio de NamedQuery</h2>");
        out.println("<pre>");
        out.println(Util.toJson(PessoaService.buscarNomesPorNamedQuery()) + "</pre></p>");
        out.println("</pre>");

        // Consulta 03a - Quais as pessoas (nome) e seus respectivos endereços (dados completos)? Por meio de Query
        out.println("<h2>Consulta 03a - Pessoas (nome) e seus respectivos endereços (dados completos) - Por meio de Query</h2>");
        out.println("<pre>");
        out.println(Util.toJson(PessoaService.buscarPessoasEnderecosPorQuery()) + "</pre></p>");
        out.println("</pre>");

        // Consulta 03b - Quais as pessoas (nome) e seus respectivos endereços (dados completos)?  Por meio de TypedQuery
        out.println("<h2>Consulta 03b - Pessoas (nome) e seus respectivos endereços (dados completos) - Por meio de TypedQuery</h2>");
        out.println("<pre>");
        out.println(Util.toJson(PessoaService.buscarPessoasEnderecosPorTypedQuery()) + "</pre></p>");
        out.println("</pre>");

        // Consulta 03c - Quais as pessoas (nome) e seus respectivos endereços (dados completos)?  Por meio de NamedQuery
        out.println("<h2>Consulta 03c - Pessoas (nome) e seus respectivos endereços (dados completos) - Por meio de NamedQuery</h2>");
        out.println("<pre>");
        out.println(Util.toJson(PessoaService.buscarPessoasEnderecosPorNamedQuery()) + "</pre></p>");
        out.println("</pre>");

        // Consulta 04a -  Quais pessoas (dados completos) moram em avenidas? Por meio de Query
        out.println("<h2>Consulta 04a - Quais pessoas (dados completos) moram em avenidas? Por meio de Query</h2>");
        out.println("<pre>");
        out.println(Util.toJson(PessoaService.buscarPessoasQueMoramEmAvenidasPorQuery()) + "</pre>");
        out.println("</pre>");

        // Consulta 04b - Quais pessoas (dados completos) moram em avenidas?   Por meio de TypedQuery
        out.println("<h2>Consulta 04b - Quais pessoas (dados completos) moram em avenidas? Por meio de TypedQuery</h2>");
        out.println("<pre>");
        out.println(Util.toJson(PessoaService.buscarPessoasQueMoramEmAvenidasPorTypedQuery()) + "</pre>");
        out.println("</pre>");

        // Consulta 04c - Quais pessoas (dados completos) moram em avenidas?   Por meio de NamedQuery
        out.println("<h2>Consulta 04c - Quais pessoas (dados completos) moram em avenidas? Por meio de NamedQuery</h2>");
        out.println("<pre>");
        out.println(Util.toJson(PessoaService.buscarPessoasQueMoramEmAvenidasPorNamedQuery()) + "</pre>");
        out.println("</pre>");

        out.println("</body>");
        out.println("</html>");
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
        return "Relatórios Servlet";
    }
}
