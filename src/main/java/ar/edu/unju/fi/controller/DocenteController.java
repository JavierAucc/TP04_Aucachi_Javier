package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.collections.ListadoAlumno;
import ar.edu.unju.fi.collections.ListadoDocentes;
import ar.edu.unju.fi.model.Docente;

@Controller
public class DocenteController {
	
	@Autowired
	Docente nuevoDocente = new Docente();
	
	@GetMapping("/formularioDocente")
	public ModelAndView getFormDocente() {
		//vista del formulario
		ModelAndView modelView = new ModelAndView("formDocente");
		//carga el objeto
		modelView.addObject("nuevoDocente",nuevoDocente);
	
		return modelView;
	}
	
	@PostMapping("/guardarDocente")
	public ModelAndView saveDocente(@ModelAttribute("nuevoDocente") Docente docenteParaGuardar) {
		//guardar
		ListadoDocentes.agregarDocente(docenteParaGuardar); //se agrega la docente
		//Una vez guardado se muestra la vista
		ModelAndView modelView = new ModelAndView("views/listaDeDocentes");//listaDeDocentes es html		
		modelView.addObject("listadoDocentes", ListadoDocentes.listarDocentes()); //el objeto ListadoDocentes
				
		return modelView;
	}
	
	@GetMapping("/borrarDocente/{legajo}")
	public ModelAndView borrarDocente(@PathVariable(name="legajo") String legajo) {
		//borrar
		ListadoDocentes.eliminarDocente(legajo);
		
		//mostrar el nuevo listado
		ModelAndView modelView = new ModelAndView("views/listaDeDocentes");
		modelView.addObject("listadoDocentes",ListadoDocentes.listarDocentes());
		
		return modelView;
		}
	
}
