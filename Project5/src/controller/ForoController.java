package controller;



import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.ForoDAOImpl;
import model.Foro;
/**
 * Servlet implementation class StudentController
 */
@WebServlet("/ForoController")
public class ForoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Foro foro;
	private List<Foro> foros;
	private ForoDAOImpl foroDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForoController() {
        super();
        foro =new Foro();
        foros= new ArrayList<Foro>();
        foroDAO=new ForoDAOImpl();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
if (request.getParameter("btn_save")!= null) {
			
			foro.setTitulo(request.getParameter("titulo"));
			foro.setDescripcion(request.getParameter("descripcion"));
			foro.setEstado(request.getParameter("estado"));
			
			
            
			if(foro.getId()==0L) {
				foroDAO.createForo(foro);
			}else {
				foroDAO.updateForo(foro);
			}
			foros=foroDAO.readAllForos();


			
			request.setAttribute("foros", foros);
			request.getRequestDispatcher("foros_list.jsp").forward(request, response);
			
		}else if (request.getParameter("btn_new")!=null) {
			foro = new Foro();
			request.getRequestDispatcher("foros_form.jsp").forward(request, response);
		
		}else if(request.getParameter("btn_edit")!=null) {	
			try {
				Long id = Long.parseLong(request.getParameter("id"));
				foro = foroDAO.readForo(id);
				
			}catch (Exception e) {
				
				foro = new Foro();
			}
			request.setAttribute("foro", foro );
			
			request.getRequestDispatcher("foros_form.jsp").forward(request, response);
			
		}else if(request.getParameter("btn_delete")!=null) {
		
			
			try {
			Long id = Long.parseLong(request.getParameter("id"));
			foroDAO.deleteForo(id);
			foros= foroDAO.readAllForos();
			
			}catch(Exception e) {
				e.printStackTrace();
				
				
			}
			request.setAttribute("foros", foros);
			request.getRequestDispatcher("foros_list.jsp").forward(request, response);
		}else {
			foros = foroDAO.readAllForos();
			request.setAttribute("foros", foros);
			request.getRequestDispatcher("foros_list.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
