package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import model.Foro;


public class ForoDAOImpl implements ForoDAO {
	private Connection connection;
	private PreparedStatement prepareStatement;
	private ResultSet resultSet;
	
	public ForoDAOImpl() {
		getConnection();
	}
	
	public  Connection getConnection() {
		try {
			Class.forName("org.postgresql.Driver");
			connection=DriverManager.getConnection("jdbc:postgresql://localhost:5432/foro","pollo","1234");
			
		}catch (SQLException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
		
	}
@Override
public void createForo(Foro foro) {
	if(connection!=null) {
		try {
		prepareStatement=connection.prepareStatement("INSERT INTO foro (titulo, descripcion,estado)values(?,?,?);");
		prepareStatement.setString(1, foro.getTitulo());
		prepareStatement.setString(2, foro.getDescripcion());
		prepareStatement.setString(3, foro.getEstado());
		prepareStatement.execute();

		System.out.print("título"+foro.getTitulo());
		System.out.print("descripción"+foro.getDescripcion());
		System.out.print("título"+foro.getEstado());
		
		
		
	}catch(SQLException e) {
		e.printStackTrace();
	}
		
	}
	
}
@Override
	public Foro readForo(Long id) {
	Foro foro=null;
	 try {
		if(connection!=null) {
			
				prepareStatement=connection.prepareStatement("SELECT * FROM foro where id=?;");
				prepareStatement.setLong(1, id);
				resultSet=prepareStatement.executeQuery();
				if(resultSet.next()) {
					foro=new Foro(resultSet.getLong(1),
							resultSet.getString(2),
							resultSet.getString(3),
							resultSet.getString(4));
					
				
				}
		}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		
		return foro;
	}
@Override
	public void deleteForo(Long id) {
	if(connection!=null) {
		try {
		prepareStatement=connection.prepareStatement("DELETE FROM foro where id=?;");
		
		prepareStatement.setLong(1,id);
		prepareStatement.execute();
	}catch(SQLException e) {
		e.printStackTrace();
	}
		
	}
		
		
	}
@Override
	public void updateForo(Foro foro) {
	if(connection!=null) {
		try {
		prepareStatement=connection.prepareStatement("UPDATE foro SET titulo =?, descripcion=?,"+
				"estado=? where id=?;");
		prepareStatement.setString(1, foro.getTitulo());
		prepareStatement.setString(2, foro.getDescripcion());
		prepareStatement.setString(3, foro.getEstado());
		prepareStatement.setLong(4, foro.getId());
		prepareStatement.execute();
	}catch(SQLException e) {
		e.printStackTrace();
	}
		
	}
		
		
	}
@Override
	public List<Foro> readAllForos() {
	List <Foro> foros=new ArrayList<Foro>();
if(connection!=null) {  //revisar si falla
		try {
			prepareStatement=connection.prepareStatement("SELECT * FROM foro");
			
			resultSet=prepareStatement.executeQuery();
			while(resultSet.next()) {
				Foro foro=new Foro(resultSet.getLong(1),
						resultSet.getString(2),
						resultSet.getString(3),
						resultSet.getString(4));
				foros.add(foro);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	return foros;
	
	}



}
