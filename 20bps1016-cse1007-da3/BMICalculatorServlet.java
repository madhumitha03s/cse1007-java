package DA3;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class BMICalculatorServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        String heightString = request.getParameter("height");
        String weightString = request.getParameter("weight");

        if (heightString != null && weightString != null) {

            double height = Double.parseDouble(heightString);
            double weight = Double.parseDouble(weightString);
            double bmi = weight / ((height / 100) * (height / 100));
            String result = "";
            if (bmi < 18.5) {
                result = "Underweight";
            } else if (bmi < 25) {
                result = "Normal";
            } else if (bmi < 30) {
                result = "Overweight";
            } else {
                result = "Obese";
            }

            out.println("<html>");
            out.println("<head>");
            out.println("<title>BMI Report</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>BMI Report</h1>");
            out.println("<p>Height: " + heightString + " cm</p>");
            out.println("<p>Weight: " + weightString + " kg</p>");
            out.println("<p>BMI: " + String.format("%.2f", bmi) + "</p>");
            out.println("<p>Result: " + result + "</p>");
            out.println("</body>");
            out.println("</html>");

        } else {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>BMI Calculator</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>BMI Calculator</h1>");
            out.println("<form method=\"post\">");
            out.println("Height (in cm): <input type=\"text\" name=\"height\"><br>");
            out.println("Weight (in kg): <input type=\"text\" name=\"weight\"><br>");
            out.println("<input type=\"submit\" value=\"Calculate\">");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
        }

        out.close();
    }
}
