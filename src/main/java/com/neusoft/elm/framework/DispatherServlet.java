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
//	�ܿ�����
	private static final long serialVersionUID = 1L;

	
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		        // ����������Ϣ���ַ����루������ʹ��request֮ǰ�������ã�
				request.setCharacterEncoding("utf-8");
				// ʹ�ͻ�������������ݲ�ͬ��MIME����������ڲ�ͬ�ĳ���Ƕ��ģ����������Ӧ�����ݡ�
				response.setContentType("text/html;charset=utf-8");
				// ������Ӧ��Ϣ���ַ����루�����ڴ�����Ӧ�����֮ǰ�������ã�
				response.setCharacterEncoding("utf-8");
				
//				��ȡ�ͻ�������·��
				String path=request.getServletPath();
				System.out.println(path);
				
				String className=path.substring(1,path.lastIndexOf("/"));
				
				String methodsName=path.substring(path.lastIndexOf("/")+1);
				PrintWriter pw=null;
				
				try {
					//��ȡ�����Ϣ
					Class clazz=Class.forName("com.neusoft.elm.controller."+className);
					//ʵ����������Ӧ�Ķ���
					Object controller=clazz.newInstance();
					//��ȡ������·��ƥ��ķ���
					Method method=clazz.getMethod(methodsName, new Class[] {HttpServletRequest.class});
					
					//���û�ȡ���ķ���
					Object result=method.invoke(controller,new Object[] {request});
					
				    pw=response.getWriter();
					//�ѷ������ص�����ת��Ϊjson���ַ���
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
