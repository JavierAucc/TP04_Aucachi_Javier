package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.collections.ListadoAlumno;
import ar.edu.unju.fi.model.Alumno;

@Controller
public class AlumnoController {
	
	@Autowired
	Alumno nuevoAlumno;
	
	@GetMapping("/formularioAlumno")
	public ModelAndView getFormAlumno() {
		//vista formCarrera.html
		ModelAndView modelView = new ModelAndView("formAlumno");
		//agrega el objeto
		modelView.addObject("nuevoAlumno", nuevoAlumno);
		modelView.addObject("band",false);
		return modelView;
	}
	
	@PostMapping("/guardarAlumno")
	public ModelAndView saveAlumno(@ModelAttribute("nuevoAlumno") Alumno alumnoParaGuardar) {
		
		//guardar
		ListadoAlumno.agregarAlumno(alumnoParaGuardar); //se agrega la alumno
		//Una vez guardado se muestra la vista
		ModelAndView modelView = new ModelAndView("views/listaDeAlumnos");//listaDeAlumnos es html		
		modelView.addObject("listadoAlumno",ListadoAlumno.listarAlumnos()); //el objeto Listadoalumnos
				
		return modelView;
	}
	@GetMapping("/borrarAlumno/{lu}")
	public ModelAndView borrarAlumno(@PathVariable(name="lu") String lu) {
		//borrar
		ListadoAlumno.eliminarAlumno(lu);
		
		//mostrar el nuevo listado
		ModelAndView modelView = new ModelAndView("views/listaDeAlumnos");
		modelView.addObject("listadoAlumno",ListadoAlumno.listarAlumnos());
		
		return modelView;
		}
	
	@GetMapping("/modificarAlumno/{lu}")
	public ModelAndView getModificarAlumno(@PathVariable(name="lu") String lu) {
		
		Alumno alumno = ListadoAlumno.buscarAlumnoPorLU(lu);
		ModelAndView modelView = new ModelAndView("formAlumno");
		
		modelView.addObject("nuevoAlumno", alumno);
		modelView.addObject("band",true);
		return modelView;
	}
	
	@PostMapping("/modificarAlumno")
	public ModelAndView modificarAlumno(@ModelAttribute("alumno") Alumno alumnoModificado) {
		ListadoAlumno.modificarAlumno(alumnoModificado);
		ModelAndView modelView = new ModelAndView("views/listaDeAlumnos");
		modelView.addObject("listadoAlumno",ListadoAlumno.listarAlumnos());
		return modelView;
			
	}
	
	
	
	
	
	
}
