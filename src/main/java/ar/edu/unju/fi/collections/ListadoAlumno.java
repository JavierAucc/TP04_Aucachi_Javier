package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.fi.model.Alumno;



public class ListadoAlumno {

	
	public static List<Alumno> alumnos= new ArrayList<Alumno>();
	
	//lista carreras
			public static List<Alumno> listarAlumnos(){
				return alumnos;
			}
			//busca carreras por codigo
			public static Alumno buscarAlumnoPorLU(String lu) {
				for(Alumno a : alumnos) {
					if(a.getLu().equals(lu)) {
							return a;
					}
				}
				return null;
			}
			//agregar carrera
			public static void agregarAlumno(Alumno a) {
				alumnos.add(a);
			}
			//modificar
			public static void modificarAlumno(Alumno alumnoAmodificar) {
				for(int i = 0; i < alumnos.size(); i++) {
					Alumno alumno = alumnos.get(i);
					if(alumno.getLu().equals(alumnoAmodificar.getLu())) {
						alumnos.set(i,alumnoAmodificar);
						break;
					}
				}
			}
			//eliminar
			public static void eliminarAlumno(String lu) {
				alumnos.removeIf(alumno -> alumno.getLu().equals(lu));//borrado fisico
				
			}
}
