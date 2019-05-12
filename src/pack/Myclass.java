package pack;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/OMEGALUL")
public class Myclass extends HttpServlet {

	private static final long serialVersionUID = -7201924861251675625L;
	private final String VALID = "^[0-9]+$";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		process(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		process(req, resp);
	}

	void process(HttpServletRequest req, HttpServletResponse resp) {
		String num1 = req.getParameter("NUMBER1");
		String num2 = req.getParameter("NUMBER2");
		System.out.println(num1 + " " + num2);
		Pattern pat1 = Pattern.compile(VALID);
		resp.setContentType("application/json");
		if (num1 != null && num2 != null) {
			
			Matcher m1 = pat1.matcher(num1);
			Matcher m2 = pat1.matcher(num2);

			if (m1.matches() && m2.matches()) {
				int i = Integer.parseInt(num1);
				int p = Integer.parseInt(num2);
				int sum = i + p;
				try {
					PrintWriter writer = resp.getWriter();
					writer.println("{ sum: " + "\"" + sum + "\"" + "}");
					//resp.getOutputStream().println("{ sum: " + "\"" + sum + "\"" + "}");

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else
				try {
					resp.getOutputStream().println("COULDNT ADD THESE 2 Numbers");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
}
