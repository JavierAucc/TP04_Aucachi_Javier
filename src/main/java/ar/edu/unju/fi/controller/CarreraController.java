package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.collections.ListadoCarreras;
import ar.edu.unju.fi.model.Carrera;

@Controller
public class CarreraController {

	@Autowired
	Carrera nuevaCarrera;
	
	@GetMapping("/formularioCarrera")
	public ModelAndView getFormCarrera() {
		//vista formCarrera.html
		ModelAndView modelView = new ModelAndView("formCarrera");
		//agrega el objeto
		modelView.addObject("nuevaCarrera", nuevaCarrera);
		modelView.addObject("band",false);
		return modelView;
	}
	
	@PostMapping("/guardarCarrera")
	public ModelAndView saveCarrera(@ModelAttribute("nuevaCarrera") Carrera carreraParaGuardar) {
		
		//guardar
		ListadoCarreras.agregarCarrera(carreraParaGuardar); //se agrega la carrera 
		//Una vez guardado se muestra la vista
		ModelAndView modelView = new ModelAndView("views/listaDeCarreras");//listaDeCarreras es el html		
		modelView.addObject("listadoCarreras", ListadoCarreras.listarCarreras()); //el objeto ListadoCarreras
				
		return modelView;
	}
	@GetMapping("/borrarCarrera/{codigo}")
	public ModelAndView borrarCarrera(@PathVariable(name="codigo") String codigo) {
		//borrar
		ListadoCarreras.eliminarCarrera(codigo);
		
		//mostrar el nuevo listado
		ModelAndView modelView = new ModelAndView("views/listaDeCarreras");
		modelView.addObject("listadoCarreras",ListadoCarreras.listarCarreras());
		
		return modelView;
		
	}
	@GetMapping("/modificarCarrera/{codigo}")
	public ModelAndView getModificarCarrera(@PathVariable(name="codigo") String codigo) {
		Carrera carrera = ListadoCarreras.buscarCarreraPorCodigo(codigo);
		//ModelAndView modelView = new ModelAndView("modificarCarrera");
		ModelAndView modelView = new ModelAndView("formCarrera");
		modelView.addObject("nuevaCarrera", carrera);
		modelView.addObject("band",true);
		return modelView;
	}
	@PostMapping("/modificarCarrera")
	public ModelAndView modificarCarrera(@ModelAttribute("carrera") Carrera carreraModificada) {
		ListadoCarreras.modificarCarrera(carreraModificada);
		ModelAndView modelView = new ModelAndView("views/listaDeCarreras");
		modelView.addObject("listadoCarreras",ListadoCarreras.listarCarreras());
		return modelView;
	
	}
	
	
}
