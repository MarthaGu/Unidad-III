package dao;

import java.util.List;

import model.Foro;


public class TestConnection {
	public static void main(String[] args) {
		ForoDAOImpl foroDAOImpl=new ForoDAOImpl();
		foroDAOImpl.createForo(new Foro(1L,"Joseé López","GSILBN", "HHH"));
		
		
			
			
			List<Foro> foros=foroDAOImpl.readAllForos();
			for(Foro foro:foros) {
				System.out.print(foro);
	}
	

}
}

