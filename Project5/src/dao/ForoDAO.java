package dao;

import java.util.List;

import model.Foro;


public interface ForoDAO {


List<Foro> readAllForos();
Foro readForo(Long id);
void createForo(Foro foro);
void deleteForo(Long id);
void updateForo(Foro foro);
	
}
