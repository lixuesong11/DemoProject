package com.neusoft.elm.framework;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;


@WebServlet("/")
public class DispatherServlet extends HttpServlet {
//	总控制器
	private static final long serialVersionUID = 1L;

	
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		        // 设置请求信息的字符编码（必须在使用request之前进行设置）
				request.setCharacterEncoding("utf-8");
				// 使客户端浏览器并根据不同的MIME调用浏览器内不同的程序嵌入模块来处理相应的数据。
				response.setContentType("text/html;charset=utf-8");
				// 设置响应信息的字符编码（必须在创建响应输出流之前进行设置）
				response.setCharacterEncoding("utf-8");
				
//				获取客户端请求路径
				String path=request.getServletPath();
				System.out.println(path);
				
				String className=path.substring(1,path.lastIndexOf("/"));
				
				String methodsName=path.substring(path.lastIndexOf("/")+1);
				PrintWriter pw=null;
				
				try {
					//获取类的信息
					Class clazz=Class.forName("com.neusoft.elm.controller."+className);
					//实例化类所对应的对象
					Object controller=clazz.newInstance();
					//获取类中与路径匹配的方法
					Method method=clazz.getMethod(methodsName, new Class[] {HttpServletRequest.class});
					
					//调用获取到的方法
					Object result=method.invoke(controller,new Object[] {request});
					
				    pw=response.getWriter();
					//把方法返回的数据转换为json的字符串
					ObjectMapper om=new ObjectMapper();
					String jsonStr=om.writeValueAsString(result);
					pw.print(jsonStr);
				} catch (Exception e) {
					e.printStackTrace();
				}finally {
					pw.close();
				}
				
				
				
				
	}

}
