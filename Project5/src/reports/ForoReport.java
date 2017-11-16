package reports;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




import dao.ForoDAOImpl;
import model.Foro;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;



@WebServlet("/ForoReport")
public class ForoReport extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ForoDAOImpl dao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForoReport() {
        super();
        dao = new ForoDAOImpl() {
			
			@Override
			public void updateForo(Foro foro) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public Foro readForo(Long id) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public List<Foro> readAllForos() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public void deleteForo(Long id) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void createForo(Foro foro) {
				// TODO Auto-generated method stub
				
			}
		};
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String reportPath = "C:\\Users\\Juan Bosco Carrillo\\JaspersoftWorkspace\\MyReports\\Foro.jrxml";
		try {
			
			JasperReport report = JasperCompileManager.compileReport(reportPath);
			
			Map<String, Object> data = new HashMap<String, Object>();
			// data.put("Image", this.getServletContext().getRealPath("/")+"/images/helloWorld.jpg");
			JasperPrint print = JasperFillManager.fillReport(report, data, dao.getConnection());
			
			JasperExportManager.exportReportToPdfStream(print, response.getOutputStream());
			
			response.getOutputStream().flush();
			response.getOutputStream().close();
			
			
			
			
		} catch (net.sf.jasperreports.engine.JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
