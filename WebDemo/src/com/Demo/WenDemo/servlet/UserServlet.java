package com.Demo.WenDemo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Demo.WenDemo.domain.User;
import com.Demo.WenDemo.service.UserServiceImpl;

import net.sf.json.JSONArray;


/**
 * Servlet implementation class UserServlet
 */
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("served at ");
		String requestType = request.getHeader("X-Requested-With");
		System.out.println(requestType);
		//跨域访问
		response.setHeader("Access-Control-Allow-Origin", "*");  
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");  
        response.setHeader("Access-Control-Max-Age", "3600");  
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with");  
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String method = request.getParameter("method");

		if ("relogin".equals(method)) { // 登录操作台
			relogin(request, response);
		} else if("regist".equals(method)) {
			regist(request, response);
		} else if("login".equals(method)) {
			login(request, response);
		}else if ("activeuser".equals(method)) {
			activecode(request, response);
		}
	}

	public void activecode(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 1.得到激活码
				String activecode = request.getParameter("activecode");

				// 2.调用UserService中的方法完成激活操作
				UserServiceImpl service = new UserServiceImpl();

				service.activeUser(activecode);

//				response.getWriter().write(
//						"用户激活成功,请<a href='" + request.getContextPath()
//								+ "/index.jsp'>回首页</a>");
				return;
	}

	public void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("denglu111");
		response.sendRedirect(request.getContextPath() + "/login.jsp");
		
	}

	public void regist(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("regist");
		User user = new User();
		user.setEmail("2719969254@qq.com");
		String name = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		System.out.println(name+"  "+password+"  "+email);
		
		 //获取当前请求的路径
        String basePath = request.getScheme() + "://" + request.getServerName() + ":"  + request.getServerPort()+request.getContextPath();
        //如果request.getHeader("X-Requested-With") 返回的是"XMLHttpRequest"说明就是ajax请求，需要特殊处理
        String requestType = request.getHeader("X-Requested-With");
        if("XMLHttpRequest".equals(requestType)){
            System.out.println("AJAX请求..");
        }else {
        	System.out.println(requestType);
        }
           System.out.println("给客户端返回json数据");
           String href=basePath+"/index.jsp";
           
           List<Object> list=new ArrayList<Object>();
           Map<String,Object> map1=new HashMap<String,Object>();
          
           map1.put("state",0);
           map1.put("message",href);
           
           list.add(map1);
           JSONArray json = JSONArray.fromObject(map1);  
           
          
       	String json2=json.toString();
       	
       	response.setContentType("application/json;charset=utf-8");  
       	PrintWriter out = response.getWriter();
       	out.write(json2);
       	out.flush();
       	out.close();
        
       
//		try {
//			BeanUtils.populate(user, request.getParameterMap());
//		} catch (IllegalAccessException e) {
//			e.printStackTrace();
//		} catch (InvocationTargetException e) {
//			e.printStackTrace();
//		}
//		// 手动封装一个激活码
//				user.setActivecode(UUID.randomUUID().toString());
//				
//
//				// 2.调用service操作
//
//				UserServiceImpl service = new UserServiceImpl();
//
//				try {
//					service.regist(user);
//
//					response.getWriter().write(
//							"注册成功，激活后请<a href='" + request.getContextPath()
//									+ "/index.jsp'>登录</a>");
//					response.sendRedirect(request.getContextPath() + "/login.jsp");
//
//				} catch (Exception e) {
//					System.out.println("调用service错误");
//					return;
//				}
		
	}

	public void relogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("denglu111");
		response.sendRedirect(request.getContextPath() + "/login.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		String requestType = request.getHeader("X-Requested-With");
		System.out.println(requestType);
	}

}
