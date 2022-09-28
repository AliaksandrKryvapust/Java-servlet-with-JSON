package groupId.artifactId.controller.servlet.ui;

import groupId.artifactId.service.ProductService;
import groupId.artifactId.service.api.IProductService;
import groupId.artifactId.utils.JsonConverter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ProductForm", urlPatterns = "/ui/product")
public class UiProductFormServlet extends HttpServlet {
    private final IProductService productService = ProductService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        try {
            resp.getWriter().write(JsonConverter.toJson(productService.getById()));
        } catch (Exception e) {
            resp.setStatus(500);
        }
        resp.setStatus(200);
    }
}
