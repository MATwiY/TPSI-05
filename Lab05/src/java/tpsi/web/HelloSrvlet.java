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

    protected int timer = 0;
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        
        HttpSession session = request.getSession();
        setTimer();
        session.setAttribute("timer", timer);
        Integer timer = (Integer) session.getAttribute("timer");
        
        List<Student> studentList = new ArrayList<>();
        
        Student s1 = new Student("Jan", "Kowalski", "janKowalski@poczta.pl");
        Student s2 = new Student("Marek", "Kowalski", "marekKowalski@poczta.pl");
        Student s3 = new Student("Mateusz", "Kowalski", "mateuszKowalski@poczta.pl");
        Student s4 = new Student("Kuba", "Kowalski", "kubaKowalski@poczta.pl");
        Student s5 = new Student("Andrzej", "Kowalski", "andrzejKowalski@poczta.pl");
        
        studentList.add(s1);
        studentList.add(s2);
        studentList.add(s3);
        studentList.add(s4);
        studentList.add(s5);
        
        session.setAttribute("studentList", studentList);

        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
    
    public int getTimer(){
        return timer;
    }
    public void setTimer(){
        timer++;
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        
        String imie = request.getParameter("imie");
        String nazwisko = request.getParameter("nazwisko");
        String email = request.getParameter("email");
        
        Student s = new Student(imie, nazwisko, email);
        
        List<Student> list = (List<Student>)session.getAttribute("studentList");
        list.add(s);
        
        session.setAttribute("studentList", list);
        setTimer();
        session.setAttribute("timer", timer);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}