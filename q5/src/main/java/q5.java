

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/q5")
public class q5 extends HttpServlet {
    private static final String VALID_USERNAME = "dukuze";
    private static final String VALID_PASSWORD = "dukuze@123";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (VALID_USERNAME.equals(username) && VALID_PASSWORD.equals(password)) {
            response.sendRedirect("wel.html");
        } else {
            out.println("<html><body>");
            out.println("<h2>Login to not well</h2>");
            out.println("<p>unknown username or password.</p>");
            out.println("<a href='form.html'>Try Again</a>");
            out.println("</body></html>");
        }
    }
}