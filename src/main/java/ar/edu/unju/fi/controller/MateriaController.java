package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.collections.ListadoCarreras;
import ar.edu.unju.fi.collections.ListadoDocentes;
import ar.edu.unju.fi.collections.ListadoMateria;
import ar.edu.unju.fi.model.Materia;
@Controller
public class MateriaController {
	
	@Autowired
	Materia nuevaMateria;
	
	@GetMapping("/formularioMateria")
	public ModelAndView getFormMateria() {
		//vista carrera
		ModelAndView modelView = new ModelAndView("formMateria");
		
		//agrega el objeto
		modelView.addObject("nuevaMateria",nuevaMateria);
		
		modelView.addObject("listadoDocentes",ListadoDocentes.listarDocentes());
		modelView.addObject("listadoCarreras",ListadoCarreras.listarCarreras());
		
		modelView.addObject("band",false);
		return modelView;
	}
	@PostMapping("/guardarMateria")
	public ModelAndView saveMateria(@ModelAttribute("nuevaMateria") Materia materiaParaGuardar) {
		materiaParaGuardar.setDocente(ListadoDocentes.buscarDocentePorLegajo(materiaParaGuardar.getDocente().getLegajo()));
		materiaParaGuardar.setCarrera(ListadoCarreras.buscarCarreraPorCodigo(materiaParaGuardar.getCarrera().getCodigo()));
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
	
	@GetMapping("/modificarMateria/{codigo}")
	public ModelAndView getModificarMateria(@PathVariable(name="codigo") String codigo) {
		
		Materia materia = ListadoMateria.buscarMateriaPorCodigo(codigo);
		ModelAndView modelView = new ModelAndView("formMateria");
		modelView.addObject("nuevaMateria", materia);
		modelView.addObject("band",true);
		
		modelView.addObject("listadoDocentes",ListadoDocentes.listarDocentes());
		modelView.addObject("listadoCarreras",ListadoCarreras.listarCarreras());
		
		return modelView;
	}
	@PostMapping("/modificarMateria")
	public ModelAndView modificarMateria(@ModelAttribute("materia") Materia materiaModificada) {
		
		materiaModificada.setDocente(ListadoDocentes.buscarDocentePorLegajo(materiaModificada.getDocente().getLegajo()));
		materiaModificada.setCarrera(ListadoCarreras.buscarCarreraPorCodigo(materiaModificada.getCarrera().getCodigo()));
		
		ListadoMateria.modificarMateria(materiaModificada);
		ModelAndView modelView = new ModelAndView("views/listaDeMaterias");
		modelView.addObject("listadoMateria",ListadoMateria.listarMaterias());
		return modelView;
		
	
	}
	
	
}
