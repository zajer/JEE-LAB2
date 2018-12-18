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
import pc.wat.jee.i6i1s1.models.TableItem;

/**
 *
 * @author Piotrek
 */
@WebServlet("/api-feeder")
public class TableFeeder extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<TableItem> tableContent = getTableContent();
        
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        resp.getWriter().write(new Gson().toJson(tableContent));

    }
    
    private List<TableItem> getTableContent(){
        List<TableItem> content = new ArrayList<>();
        TableItem item1 = new TableItem();
        item1.setItemName("item1");
        item1.setItemPrice(77);
        item1.setName("myName");
        
        TableItem item2 = new TableItem();
        item2.setItemName("item2");
        item2.setItemPrice(777);
        item2.setName("myName2");
        content.add(item2);
        content.add(item1);
        
        return content;
    }
    
    
}
