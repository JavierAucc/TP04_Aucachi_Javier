package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.collections.ListadoMateria;
import ar.edu.unju.fi.model.Materia;
@Controller
public class MateriaController {
	
	@Autowired
	Materia nuevaMateria = new Materia();
	
	@GetMapping("/formularioMateria")
	public ModelAndView getFormMateria() {
	//vista carrera
		ModelAndView modelView = new ModelAndView("formMateria");
		//agrega el objeto
		modelView.addObject("nuevaMateria",nuevaMateria);
		
		return modelView;
	}
	@PostMapping("/guardarMateria")
	public ModelAndView saveMateria(@ModelAttribute("nuevaMateria") Materia materiaParaGuardar) {
		
		//guardar
		ListadoMateria.agregarMateria(materiaParaGuardar); //se agrega la materia
		//Una vez guardado se muestra la vista
		ModelAndView modelView = new ModelAndView("views/listaDeMaterias");//listaDeMaterias es html		
		modelView.addObject("listadoMateria", ListadoMateria.listarMaterias()); //el objeto ListadoMateria
				
		return modelView;
	}
	
	@GetMapping("/borrarMateria/{codigo}")
	public ModelAndView borrarMateria(@PathVariable(name="codigo") String codigo) {
		//borrar
		ListadoMateria.eliminarMateria(codigo);
		
		//mostrar el nuevo listado
		ModelAndView modelView = new ModelAndView("views/listaDeMaterias");
		modelView.addObject("listadoMateria",ListadoMateria.listarMaterias());
		
		return modelView;
		}
	
	
}
