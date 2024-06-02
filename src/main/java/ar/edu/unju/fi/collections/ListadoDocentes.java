package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.fi.model.Docente;

public class ListadoDocentes {
	
	
	public static List<Docente> docentes= new ArrayList<Docente>();
	
	//lista carreras
		public static List<Docente> listarDocentes(){
			return docentes;
		}
		//busca carreras por codigo
		public static Docente buscarDocentePorLegajo(String leg) {
			for(Docente d : docentes) {
				if(d.getLegajo().equals(leg)) {
						return d;
				}
			}
			return null;
		}
		//agregar carrera
		public static void agregarDocente(Docente d) {
			docentes.add(d);
		}
		//modificar
		public static void modificarDocente(Docente docenteAmodificar) {
			for(int i = 0; i < docentes.size(); i++) {
				Docente docente = docentes.get(i);
				if(docente.getLegajo().equals(docenteAmodificar.getLegajo())) {
					docentes.set(i,docenteAmodificar);
					break;
				}
			}
		}
		//eliminar
		public static void eliminarDocente(String legajo) {
			docentes.removeIf(docente -> docente.getLegajo().equals(legajo));
		}
	
}
