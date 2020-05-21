package atj;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CounterServlet
 */
@WebServlet("/CounterServlet")
public class CounterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public int licz = 0;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CounterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String sessionText = (String) session.getAttribute("sessionAttribute");
		String actualText = (String) request.getParameter("tekst");
		
		if(!(actualText==null)) {
			if(!actualText.equals(sessionText)) {
				licz = 0;
				session.setAttribute("sessionAttribute", actualText);
			}
		} else {
			actualText = "sample_text";
			session.setAttribute("sessionAttribute", "sample_text");
		}
		
		response.getWriter().append("<!DOCTYPE html>")
			.append("<html>")
			.append("<head><meta charset=\"UTF-8\">")
			.append("<title>ATJ_homework</title>")
			.append("</head>")
			.append("<body>")
			.append("<h2>Licznik</h2>")
			.append("<form action=\"CounterServlet\" method=\"post\"")
			.append("style=\"border-style:solid;")
			.append("border-width:1px;")
			.append("width:300px;")
			.append("padding:5px\">")
			.append("Nazwa: ")
			.append("<input type=\"text\" name=\"tekst\" value=" + actualText + ">")
			.append("<br><br>")
			.append("Licznik: ")
			.append("<input type=\"text\" name=\"licznik\" value=" + licz + ">")
			.append("<br><br>")
			.append("<input type=\"submit\" name = 'btn' value=\"Wyslij\">")
			.append("</form>")
			.append("<p>jak naciœniesz przycisk \"Wyœlij\", zwiêksza siê licznik.</p>")
			.append("<p>jak zmienisz nazwê i naciœniesz przycisk \"Wyœlij\", licznik siê wyzeruje.</p>")
			.append("</body>")
			.append("</html>");
		licz++;
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
