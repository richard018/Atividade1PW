import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "listaProdutos", urlPatterns = {"/listaProdutos"})
public class listaProdutos extends HttpServlet {


    List<Produto> ListaProdutos;

    public listaProdutos(){
        ListaProdutos = new ArrayList<>();
        var p1 = new Produto(1,"caneta", "azul", 1.5);
        var p2 = new Produto(1,"caderno", "grande", 14.0);
        var p3 = new Produto(1,"borracha", "nova", 1.0);
        var p4 = new Produto(1,"Lapis", "preto", 1.0);
        var p5 = new Produto(1,"mes", "laranja", 50.0);

        ListaProdutos.add(p1);
        ListaProdutos.add(p2);
        ListaProdutos.add(p3);
        ListaProdutos.add(p4);
        ListaProdutos.add(p5);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        var out = response.getWriter();
        response.setContentType("text/html");
        out.println("<html>");
        out.println("<body>");
        out.println("<table>");
        out.println("<tr>");
        out.println("<th> id </th>");
        out.println("</th> nome </th>");
        out.println("</th> descricao </th>");
        out.println("</th> preco </th>");
        out.println("</tr>");
        for (var i : ListaProdutos ){
            out.println("<tr>");
            out.println("<td>" + i.getId() + "</td>");
            out.println("<td>" + i.getNome()+ "</td>");
            out.println("<td>" + i.getDescricao()+ "</td>");
            out.println("<td>" + i.getPreco()+ " </td>");
            out.println("<td> <a href='/adicionarCarrinho? id="+ i.getId() + "'> Add </a> </td>");
            out.println("</tr>");

        }
        out.println("</table>");
        out.println("</body>");
        out.println("</html>");
    }
}