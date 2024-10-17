package controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import dto.Product_DTO;
import entity.Product;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;

@WebServlet(name = "HomeProduct", urlPatterns = {"/HomeProduct"})
public class HomeProduct extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        
        ArrayList<Product_DTO> productArray = new ArrayList<>();
        Session session = HibernateUtil.getSessionFactory().openSession();

        JsonObject jsonObject = new JsonObject();

        Criteria criteria2 = session.createCriteria(Product.class);
        List<Product> products = criteria2.list();

        for (Product product : products) {

            Product_DTO product_DTO = new Product_DTO();
            product_DTO.setId(product.getId());
            product_DTO.setTitle(product.getTitle());
            product_DTO.setDescription(product.getDescription());
            product_DTO.setDate_time(product.getDate_time());
            product_DTO.setPrice(product.getPrice());
            product_DTO.setQty(product.getQty());
            
//            product_DTO.setM
            
            productArray.add(product_DTO);
        
        }
         
        jsonObject.add("productList", gson.toJsonTree(productArray));
        System.out.println(jsonObject);
        System.out.println("hrllo");
        
        response.setContentType("application/json");
        response.getWriter().write(gson.toJson(jsonObject));
        session.close();
    }

}
