package com.coeding.mvc;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.coeding.mvc.bind.DataBinding;
import com.coeding.mvc.bind.ServletRequestDataBinder;
import com.coeding.mvc.controller.Controller;
import com.coeding.mvc.listener.ContextLoaderListener;
import com.coeding.mvc.vo.ProductVO;

/**
 * 
 * role of DispatcherServlet 1. receive all request call "Front Controller" +
 * URL ? + select Controller 2. logic -> delegate to Controller.execute() with
 * Interface + if need data, pass model to controller + return result, view(jsp)
 * 3. response + view -> response to client
 * 
 * @author Administrator
 *
 */
@WebServlet(description = "front controller", urlPatterns = { "*.do" })
@MultipartConfig
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DispatcherServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/*
	 * dispatching follow request URL
	 * 
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Dispatcher -->");
		// korean, eng, vietnamese <-- standard
		response.setContentType("text/html;charset=UTF-8");
		String servletPath = request.getServletPath();

		ApplicationContextReader appContext = ContextLoaderListener.getApplicationContext();

		Controller controller = (Controller) appContext.getBean(servletPath);
		if (controller == null) {
			System.out.println("have no controller");
		}

		try {
			HashMap<String, Object> model = new HashMap<String, Object>();
			String viewUrl;
			// check controller need data

			if (controller instanceof DataBinding) {
				bindRequestData(request, model, (DataBinding) controller);
			}
			System.out.println("sp " + servletPath);
			System.out.println("sp " + request.getMethod());

			if ((servletPath.equals("/admin/product/new.do") && request.getMethod().equals("POST"))
					|| (servletPath.equals("/admin/product/edit.do") && request.getMethod().equals("POST"))) {
				model.put("parts", request.getParts());
				model.put("request", request);
			}
			if("/user/login.do".equals(servletPath) || "/user/logout.do".equals(servletPath)) {
				model.put("request", request);
			}

			// delegate logics
			viewUrl = controller.execute(model);

			// model has result datas ( one and more )
			for (String key : model.keySet()) {
				request.setAttribute(key, model.get(key));
			}

			// forward view
			if (viewUrl.startsWith("redirect:")) {
//				return "redirect:/webservlet/blogger/list.do";
				response.sendRedirect(viewUrl.substring(9));
			} else {
//				return "/jsp/blogger/join.jsp";
				RequestDispatcher dis = request.getRequestDispatcher(viewUrl);
				dis.forward(request, response);
			}

		} catch (

		Exception e) {
			// change URl by client
			// all exception catch
			e.printStackTrace();
			response.sendRedirect(request.getContextPath()+"/error.jsp");
			
		}

	}

	private void bindRequestData(HttpServletRequest request, HashMap<String, Object> model, DataBinding controller) {
		// TODO: request paramater -> model.put
		Object[] databinders = controller.getDataBinders();
		String dataName = null;// variable name
		Class<?> dataType = null;// ?.class
		Object dataObj = null; // instace of dataType

		for (int i = 0; i < databinders.length; i += 2) {
			dataName = (String) databinders[i];
			dataType = (Class<?>) databinders[i + 1];// <-- ArticleVo, BloggerVO
			// System.out.println(dataName);
			// System.out.println((String)databinders[i+1]);
			// create instance of dataType
			dataObj = ServletRequestDataBinder.bind(request, dataType, dataName);
			model.put(dataName, dataObj);// to controller
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
