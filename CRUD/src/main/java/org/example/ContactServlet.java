package org.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/contacts")
public class ContactServlet extends HttpServlet {

    private List<String> contactNumbers = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Handle deletion of a contact in get request

        String deleteIndex = request.getParameter("delete");
        if (deleteIndex != null) {
            int index = Integer.parseInt(deleteIndex);
            if (index >= 0 && index < contactNumbers.size()) {
                contactNumbers.remove(index);
            }
        }

        // Display the contact list
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<h1>Contact List</h1>");
        out.println("<form action='/CRUD/contacts' method='post'>");
        out.println("Add Contact: <input type='text' name='contact'>");
        out.println("<input type='submit' value='Add'></form>");

        out.println("<h2>All Contacts</h2>");
        out.println("<ul>");
        for (int i = 0; i < contactNumbers.size(); i++) {
            String contact = contactNumbers.get(i);
            out.println("<li>" + contact + " <a href='/CRUD/contacts?delete=" + i + "'>Delete</a></li>");
        }
        out.println("</ul>");
        out.println("</body></html>");
    }
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setContentType("text/html");
//        PrintWriter out = response.getWriter();
//
//        out.println("<html><body>");
//        out.println("<h1>Contact List</h1>");
//        out.println("<form action='/CRUD/contacts' method='post'>");
//        out.println("Add Contact: <input type='text' name='contact'>");
//        out.println("<input type='submit' value='Add'></form>");
//
//        out.println("<h2>All Contacts</h2>");
//        out.println("<ul>");
//        for (int i = 0; i < contactNumbers.size(); i++) {
//            String contact = contactNumbers.get(i);
//            out.println("<li>" + contact + " <a href='/CRUD/contacts?delete=" + i + "'>Delete</a></li>");
//        }
//        out.println("</ul>");
//        out.println("</body></html>");
//    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String newContact = request.getParameter("contact");
        if (newContact != null && !newContact.isEmpty()) {
            contactNumbers.add(newContact);
        }
        response.sendRedirect("/CRUD/contacts");
    }

//    @Override
//    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String deleteIndex = request.getParameter("delete");
//        if (deleteIndex != null) {
//            int index = Integer.parseInt(deleteIndex);
//            if (index >= 0 && index < contactNumbers.size()) {
//                contactNumbers.remove(index);
//                System.out.println(index);
//            }
//        }
//        response.sendRedirect("/CRUD/contacts");
//    }
}
