

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/quadratic")
public class quadratic extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // Get coefficients from the form
        double a = Double.parseDouble(request.getParameter("a"));
        double b = Double.parseDouble(request.getParameter("b"));
        double c = Double.parseDouble(request.getParameter("c"));
        
        // Prepare response
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");

        // Check if a is zero
        if (a == 0) {
            out.println("<h3>Coefficient 'a' cannot be zero for a quadratic equation.</h3>");
        } else {
            // Calculate the discriminant
            double discriminant = b * b - 4 * a * c;
            if (discriminant > 0) {
                double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
                double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
                out.println("<h3>Roots are real and different:</h3>");
                out.println("Root 1: " + root1 + "<br>");
                out.println("Root 2: " + root2 + "<br>");
            } else if (discriminant == 0) {
                double root = -b / (2 * a);
                out.println("<h3>Roots are real and the same:</h3>");
                out.println("Root: " + root + "<br>");
            } else {
                out.println("<h3>Roots are complex:</h3>");
                double realPart = -b / (2 * a);
                double imaginaryPart = Math.sqrt(-discriminant) / (2 * a);
                out.println("Root 1: " + realPart + " + " + imaginaryPart + "i<br>");
                out.println("Root 2: " + realPart + " - " + imaginaryPart + "i<br>");
            }
        }

        out.println("<br><a href='quadraticForm.html'>Solve another equation</a>");
        out.println("</body></html>");
    }
}