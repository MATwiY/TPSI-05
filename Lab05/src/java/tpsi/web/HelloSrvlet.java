package tpsi.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "HelloSrvlet", urlPatterns = {"/"})
public class HelloSrvlet extends HttpServlet {

    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        
        HttpSession session = request.getSession();
        
        Integer timer = (Integer) session.getAttribute("timer");
        if(timer == null){
            timer = 0;
        }
          timer++;
        
        session.setAttribute("timer", timer);
        
        List<Student> studentList = (List<Student>) session.getAttribute("studentList");
        
        if(studentList == null){
            studentList = new ArrayList<>();
        }
        
        
        
        session.setAttribute("studentList", studentList);

        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
   
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        
        String imie = request.getParameter("imie");
        String nazwisko = request.getParameter("nazwisko");
        String email = request.getParameter("email");
        
        Student s = new Student(imie, nazwisko, email);
        
        List<Student> studentList = (List<Student>) session.getAttribute("studentList");
        
        if(studentList == null){
            studentList = new ArrayList<>();
        }
        studentList.add(s);
        session.setAttribute("studentList", studentList);
        
        Integer timer = (Integer) session.getAttribute("timer");
        if(timer == null){
            timer = 0;
        }
           timer++;
      
        
        session.setAttribute("timer", timer);

        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}