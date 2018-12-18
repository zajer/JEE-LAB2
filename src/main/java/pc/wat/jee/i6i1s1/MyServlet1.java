/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pc.wat.jee.i6i1s1;

import com.google.gson.Gson;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pc.wat.jee.i6i1s1.models.DataModel1;

/**
 *
 * @author Piotrek
 */
@WebServlet("/yolo")
public class MyServlet1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DataModel1 dm1 = new DataModel1();
        List<String> myArr = new ArrayList<>();
        
        String result = new Gson().toJson(myArr);
        
        dm1.setStudentName("Super student");
        dm1.setStudentGroup("I6I1S1");
        
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(new Gson().toJson(dm1));
    }
    
}
