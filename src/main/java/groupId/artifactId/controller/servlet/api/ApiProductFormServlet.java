package groupId.artifactId.controller.servlet.api;

import groupId.artifactId.service.ProductService;
import groupId.artifactId.service.api.IProductService;
import groupId.artifactId.utils.JsonConverter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.Collectors;

@WebServlet(name = "ProductFormData", urlPatterns = "/api/product_form")
public class ApiProductFormServlet extends HttpServlet {
    private final IProductService productService = ProductService.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        String jsonString = req.getReader().lines().collect(Collectors.joining());
        try {
            productService.add(JsonConverter.fromJson(jsonString));
        } catch (Exception e) {
            resp.setStatus(500);
        }
        resp.setStatus(201);
    }
}
