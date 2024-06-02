package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.fi.model.Carrera;

public class ListadoCarreras {

	public static List<Carrera> carreras= new ArrayList<Carrera>();
	
	//lista carreras
	public static List<Carrera> listarCarreras(){
		return carreras;
	}
	//busca carreras por codigo
	public static Carrera buscarCarreraPorCodigo(String cod) {
		for(Carrera c : carreras) {
			if(c.getCodigo().equals(cod)) {
					return c;
			}
		}
		return null;
	}
	//agregar carrera
	public static void agregarCarrera(Carrera c) {
		//antes de agregar se cambia el estado de carrera
		c.setEstado(true);
		carreras.add(c);
	}
	//modificar
	public static void modificarCarrera(Carrera carreraAmodificar) {
		for(int i = 0; i < carreras.size(); i++) {
			Carrera carrera = carreras.get(i);
			if(carrera.getCodigo().equals(carreraAmodificar.getCodigo())) {
				carreras.set(i,carreraAmodificar);
				break;
			}
		}
	}
	//eliminar
	public static void eliminarCarrera(String codigo) {
		//carreras.removeIf(carrera -> carrera.getCodigo().equals(codigo)); //borrado fisico
		for(int i = 0; i < carreras.size(); i++) { // borrado logico
			Carrera carrera = carreras.get(i);
			if(carrera.getCodigo().equals(codigo)) {
				carrera.setEstado(false);
				break;
			}
		}
	}
	
}
