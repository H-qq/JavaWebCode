package servlets; /**
 * @author hongtao
 * @create 2022-05-17-18:35
 */


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Complex;
@WebServlet("/calculate")
public class CaculateServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        double r1 = Double.parseDouble(request.getParameter("r1"));
        double i1 = Double.parseDouble(request.getParameter("i1"));
        String oper = request.getParameter("oper");
        double r2 = Double.parseDouble(request.getParameter("r2"));
        double i2 = Double.parseDouble(request.getParameter("i2"));
        String result = "";
        Complex c1 = new Complex(r1, i1);
        Complex c2 = new Complex(r2, i2);
        if ("+".equals(oper)) {
            result = c1.add(c2).info();
        } else if ("-".equals(oper)) {
            result = c1.sub(c2).info();
        } else if ("*".equals(oper)) {
            result = c1.mul(c2).info();
        } else {
            result = c1.div(c2).info();
        }
        request.setAttribute("outputMessage", result);
        request.getRequestDispatcher("/output.jsp").forward(request, response);
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}