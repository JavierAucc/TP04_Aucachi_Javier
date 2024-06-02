package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.fi.model.Materia;



public class ListadoMateria {

	public static List<Materia> materias= new ArrayList<Materia>();
	
	//lista carreras
	public static List<Materia> listarMaterias(){
		return materias;
	}
	//busca carreras por codigo
	public static Materia buscarMateriaPorCodigo(String cod) {
		for(Materia m : materias) {
			if(m.getCodigo().equals(cod)) {
					return m;
			}
		}
		return null;
	}
	//agregar carrera
	public static void agregarMateria(Materia m) {
		materias.add(m);
	}
	//modificar
	public static void modificarMateria(Materia materiaAmodificar) {
		for(int i = 0; i < materias.size(); i++) {
			Materia materia = materias.get(i);
			if(materia.getCodigo().equals(materiaAmodificar.getCodigo())) {
				materias.set(i,materiaAmodificar);
				break;
			}
		}
	}
	//eliminar
	public static void eliminarMateria(String cod) {
		materias.removeIf(materia -> materia.getCodigo().equals(cod));
	}
	
	
	
}
