/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.User;

/**
 *
 * @author Petra Barus
 */
public class Login extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User currentuser = (User) request.getSession().getAttribute("currentuser");
        if (currentuser != null) {
            response.sendRedirect("home");
        } else {
            request.getRequestDispatcher("views/login.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Melakukan pengecekan session
        User currentuser = (User) request.getSession().getAttribute("currentuser");
        //Jika user sudah login
        if (currentuser != null) {
            response.sendRedirect("home");
        } else {
            try {
                String username = request.getParameter("username");
                String password = request.getParameter("password");
                currentuser = new User(username, password);
                //Login
                currentuser.login();
                //Penyimpanan ke session
                request.getSession(true).setAttribute("currentuser", currentuser);
                //Redirect
                response.sendRedirect("home");
            } catch (Exception ex) {
                //Redirect
                response.sendRedirect("error?message="+ex.getMessage());
            }
        }
    }
}
