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
	Alumno nuevoAlumno = new Alumno();
	
	@GetMapping("/formularioAlumno")
	public ModelAndView getFormAlumno() {
		//vista formCarrera.html
		ModelAndView modelView = new ModelAndView("formAlumno");
		//agrega el objeto
		modelView.addObject("nuevoAlumno", nuevoAlumno);
		
		return modelView;
	}
	
	@PostMapping("/guardarAlumno")
	public ModelAndView saveAlumno(@ModelAttribute("nuevoAlumno") Alumno alumnoParaGuardar) {
		
		//guardar
		ListadoAlumno.agregarAlumno(alumnoParaGuardar); //se agrega la alumno
		//Una vez guardado se muestra la vista
		ModelAndView modelView = new ModelAndView("views/listaDeAlumnos");//listaDeAlumnos es html		
		modelView.addObject("listadoAlumno", ListadoAlumno.listarAlumnos()); //el objeto ListadoCarreras
				
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
	
}
