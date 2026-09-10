package ex6;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ResultServlet")
public class myservlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String regno = request.getParameter("regno");
        String name = request.getParameter("name");
        String department = request.getParameter("department");

        int mark1 = Integer.parseInt(request.getParameter("mark1"));
        int mark2 = Integer.parseInt(request.getParameter("mark2"));
        int mark3 = Integer.parseInt(request.getParameter("mark3"));
        int mark4 = Integer.parseInt(request.getParameter("mark4"));
        int mark5 = Integer.parseInt(request.getParameter("mark5"));

        double attendance =
                Double.parseDouble(request.getParameter("attendance"));

        int total = mark1 + mark2 + mark3 + mark4 + mark5;

        double average = total / 5.0;

        String grade;

        if (average >= 90) {
            grade = "O";
        }
        else if (average >= 80) {
            grade = "A+";
        }
        else if (average >= 70) {
            grade = "A";
        }
        else if (average >= 60) {
            grade = "B+";
        }
        else if (average >= 50) {
            grade = "B";
        }
        else if (average >= 40) {
            grade = "C";
        }
        else {
            grade = "F";
        }

        boolean eligible = attendance >= 75;

        boolean subjectPass =
                mark1 >= 40 &&
                mark2 >= 40 &&
                mark3 >= 40 &&
                mark4 >= 40 &&
                mark5 >= 40;

        boolean averagePass = average >= 50;

        boolean pass =
                eligible &&
                subjectPass &&
                averagePass;

        String result;

        if (pass) {
            result = "PASS";
        }
        else {
            result = "FAIL";
        }

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Examination Result</title>");

        out.println("<style>");

        out.println("body {"
                + "font-family: Arial;"
                + "background-color: #f2f2f2;"
                + "}");

        out.println(".container {"
                + "width: 700px;"
                + "margin: 40px auto;"
                + "background: white;"
                + "padding: 25px;"
                + "border-radius: 10px;"
                + "}");

        out.println("h1 {"
                + "text-align: center;"
                + "}");

        out.println("table {"
                + "width: 100%;"
                + "border-collapse: collapse;"
                + "}");

        out.println("th, td {"
                + "border: 1px solid black;"
                + "padding: 10px;"
                + "text-align: center;"
                + "}");

        out.println("th {"
                + "background-color: #ddd;"
                + "}");

        out.println("</style>");
        out.println("</head>");

        out.println("<body>");

        out.println("<div class='container'>");

        out.println("<h1>Student Examination Result</h1>");

        out.println("<h3>Student Details</h3>");

        out.println("<table>");

        out.println("<tr>");
        out.println("<th>Register Number</th>");
        out.println("<td>" + regno + "</td>");
        out.println("</tr>");

        out.println("<tr>");
        out.println("<th>Student Name</th>");
        out.println("<td>" + name + "</td>");
        out.println("</tr>");

        out.println("<tr>");
        out.println("<th>Department</th>");
        out.println("<td>" + department + "</td>");
        out.println("</tr>");

        out.println("<tr>");
        out.println("<th>Attendance</th>");
        out.println("<td>" + attendance + "%</td>");
        out.println("</tr>");

        out.println("</table>");

        out.println("<h3>Subject Marks</h3>");

        out.println("<table>");

        out.println("<tr>");
        out.println("<th>Subject</th>");
        out.println("<th>Mark</th>");
        out.println("</tr>");

        out.println("<tr>");
        out.println("<td>Subject 1</td>");
        out.println("<td>" + mark1 + "</td>");
        out.println("</tr>");

        out.println("<tr>");
        out.println("<td>Subject 2</td>");
        out.println("<td>" + mark2 + "</td>");
        out.println("</tr>");

        out.println("<tr>");
        out.println("<td>Subject 3</td>");
        out.println("<td>" + mark3 + "</td>");
        out.println("</tr>");

        out.println("<tr>");
        out.println("<td>Subject 4</td>");
        out.println("<td>" + mark4 + "</td>");
        out.println("</tr>");

        out.println("<tr>");
        out.println("<td>Subject 5</td>");
        out.println("<td>" + mark5 + "</td>");
        out.println("</tr>");

        out.println("<tr>");
        out.println("<th>Total</th>");
        out.println("<th>" + total + " / 500</th>");
        out.println("</tr>");

        out.println("<tr>");
        out.println("<th>Average</th>");
        out.println("<th>"
                + String.format("%.2f", average)
                + "%"
                + "</th>");
        out.println("</tr>");

        out.println("<tr>");
        out.println("<th>Grade</th>");
        out.println("<th>" + grade + "</th>");
        out.println("</tr>");

        out.println("</table>");

        out.println("<h3>Eligibility Details</h3>");

        out.println("<p><b>Attendance Eligibility:</b> "
                + (eligible ? "Eligible" : "Not Eligible")
                + "</p>");

        out.println("<p><b>Subject-wise Minimum Mark:</b> "
                + (subjectPass ? "Satisfied" : "Not Satisfied")
                + "</p>");

        out.println("<p><b>Overall Average:</b> "
                + (averagePass ? "Satisfied" : "Not Satisfied")
                + "</p>");

        out.println("<h2>Final Result: " + result + "</h2>");

        out.println("</div>");

        out.println("</body>");
        out.println("</html>");
    }
}