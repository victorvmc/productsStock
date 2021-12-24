package br.com.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.beans.Product;
import br.com.dao.ProductDao;
import br.com.utils.BeanUtilities;

/**
 * Servlet implementation class Controller
 */
public class  ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductDao productdao;
	String forward;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductController() {
		super();
		productdao = new ProductDao();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String app = request.getParameter("app");
		System.out.println(app);;

		if ((app==null)  || (app.equalsIgnoreCase("listProducts"))) {
			forward = "views/list.jsp";
			request.setAttribute("products", productdao.getAllProducts());
		} else
			if (app.equalsIgnoreCase("create")) {
				forward = "views/create.jsp";
			} else
				if (app.equalsIgnoreCase("delete")) {
					forward = "views/list.jsp";
					int id = Integer.parseInt(request.getParameter("productId"));
					productdao.deleteProduct(id);
					request.setAttribute("products", productdao.getAllProducts());
				}else
					if (app.equalsIgnoreCase("update")) {
						forward = "views/create.jsp";
						int id = Integer.parseInt(request.getParameter("productId"));
						request.setAttribute("product", productdao.getProductById(id));
						System.out.println("ID:" + id);
					}

		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		forward = "views/list.jsp";
		Product product = new Product();
		BeanUtilities.populateBean(product, request);		
		
		if (product.getId() == 0) {
			productdao.addProduct(product);
		} else {
			productdao.updateProduct(product);
		}
		
		request.setAttribute("clientes", productdao.getAllProducts());
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

}
