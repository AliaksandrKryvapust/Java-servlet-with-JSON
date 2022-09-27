package groupId.artifactId.controller.servlet.ui;

import com.google.gson.JsonParseException;
import groupId.artifactId.service.ProductService;
import groupId.artifactId.service.api.IProductService;
import groupId.artifactId.utils.JsonConverter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ProductForm", urlPatterns = "/ui/product_form")
public class UiProductFormServlet extends HttpServlet {
    private final IProductService productService = ProductService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        try {
            resp.getWriter().write(JsonConverter.toJson(productService.getById()));
        } catch (JsonParseException e) {
            throw new ServletException(e);
        }
    }
}
