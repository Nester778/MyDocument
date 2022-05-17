

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.json.JSONParser;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;



@WebServlet("/sabmit")
public class Sabmit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String planet = request.getParameter("planet");
		
		File client = new File("./Client.txt");
		if(!client.exists()) {
			client.createNewFile();	
		}
		
		BufferedReader br = new BufferedReader(new FileReader("./Client.txt"));
		String line;
		int b = 1;
		int count = 0;

		ArrayList<String> Clients = new ArrayList<>();
		for(;(line = br.readLine()) != null;b++) {
			String[] subStr;
		    String delimeter = "!"; 
		    subStr = line.split(delimeter);
			Clients.add(subStr[1]);
		}
		
		String str = Integer.toString(b);
		String status = "в обробці";
		boolean t = true;
		for(int i = 0;i<Clients.size();i++)
		{
			if(phone.equals(Clients.get(i))) {
				t = false;
				str = "Повторная запись";
				name = "Повторная запись";
				phone = "Повторная запись";
				planet = "Повторная запись";
				status = "Повторная запись";
			}
		}
		
		
		
		if(t) {
			FileWriter writer = new FileWriter("./Client.txt", true);
			BufferedWriter bufferWriter = new BufferedWriter(writer);
	        bufferWriter.write(name+"!"+phone+"!"+planet+"\n");
	        bufferWriter.close();
			writer.close();
		}
		
		
		
			
		String sabHtml ="<!DOCTYPE html>\r\n"
				+ "<html>\r\n"
				+ "<head>\r\n"
				+ "	<meta charset=\"UTF-8\">\r\n"
				+ "	<link rel=\"stylesheet\" href=\"./style/StyleSabmit.css\">\r\n"
				+ "	<title>Insert title here</title>\r\n"
				+ "	<link href=\"http://fonts.cdnfonts.com/css/roboto\" rel=\"stylesheet\">\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "	<header class=\"header\">\r\n"
				+ "        <nav class=\"nav-bar secondary-text\">\r\n"
				+ "            <div class=\"nav-bar-wrapper\">\r\n"
				+ "                <div class=\"nav-logo-wrapper\">\r\n"
				+ "                    <a class=\"nav-logo\" href = \"./index.html\"></a>\r\n"
				+ "                    <span class=\"nav-title\">My Document</span>\r\n"
				+ "                </div>\r\n"
				+ "\r\n"
				+ "                <div class=\"nav-menu-wrapper\">\r\n"
				+ "                    <span class=\"nav-menu-item\">Про нас</span>\r\n"
				+ "                    <a href=\"./hendels.html\" class=\"nav-menu-item\" >Оператори</a>\r\n"
				+ "                    <span class=\"nav-menu-item\">Новини</span>\r\n"
				+ "                    <i class=\"nav-menu-icon\"></i>\r\n"
				+ "                </div>\r\n"
				+ "\r\n"
				+ "                <div class=\"menu-button\"></div>\r\n"
				+ "            </div>\r\n"
				+ "        </nav>\r\n"
				+ "    </header>\r\n"
				+ "	\r\n"
				+ "	<div class=\"page-wrapper\">\r\n"
				+ "	    <section class=\"registration-section\">\r\n"
				+ "	        <div class=\"registration-form-wrapper\">\r\n"
				+ "	\r\n"
				+ "	            <div class=\"form-card flex-column\">\r\n"
				+ "	                <div class=\"form-wrapper\">\r\n"
				+ "	\r\n"
				+ "	                    <h2 class=\"form-title\">Ви успішно\r\n"
				+ "	                       <span id=\"text-to-change\">Зареєструвалися</span></h2>\r\n"
				+ "\r\n"
				+ "                        <p class=\"form-card-text\">Місце в черзі: "+str+"</p>\r\n"
				+ "                        <p class=\"form-card-text\">Ім'я: "+name+"</p>\r\n"
				+ "                        <p class=\"form-card-text\">Телефон: "+phone+"</p>\r\n"
				+ "                        <p class=\"form-card-text\">Планета: "+planet+"</p>\r\n"
				+ "                        <p class=\"form-card-text\">Стан: "+status+"</p>\r\n"
				+ "  \r\n"
				+ "	                </div>\r\n"
				+ "	           </div>\r\n"
				+ "	        </div>\r\n"
				+ "	    </section>\r\n"
				+ "	</div>\r\n"
				+ "	\r\n"
				+ "	<footer class=\"footer secondary-text\">\r\n"
				+ "        <span class=\"footer-credentials\">\r\n"
				+ "            © 2022 My Document. Всі права захищені.\r\n"
				+ "        </span>\r\n"
				+ "    </footer>\r\n"
				+ "</body>\r\n"
				+ "</html>";
		response.getWriter().write(sabHtml);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
