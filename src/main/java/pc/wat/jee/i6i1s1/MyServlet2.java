/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pc.wat.jee.i6i1s1;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Piotrek
 */
@WebServlet("/api-cookie")
public class MyServlet2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] availableCookies = req.getCookies();
        List<Cookie> listOfCookies = Arrays.asList(availableCookies);
        String result;
        boolean isPermanentlyAuthenticated = listOfCookies.stream().anyMatch( ck -> ck.getName().equals("myPersValue") );
        if(isPermanentlyAuthenticated)
            result = generateResultForPermanentlyAuthenticatedUser();
        else
            result = generateResultForNotPermanentlyAuthenticatedUser();
        

        resp.getWriter().write(result);
    }

    
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie ck = new Cookie("myPersKey", "myPersVal");
        
        resp.addCookie(ck);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie ck = new Cookie("myNPersKey", "myNPersVal");
        ck.setMaxAge(60);
        resp.addCookie(ck);
    }

    private String generateResultForNotPermanentlyAuthenticatedUser() {
        return "SUP";
    }

    private String generateResultForPermanentlyAuthenticatedUser() {
        return "hello";
    }
    
    
    
    
    
}
