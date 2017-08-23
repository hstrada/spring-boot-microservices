package br.com.fiap.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.bean.Curso;
import br.com.fiap.dao.CursoDAO;

@RestController
@RequestMapping("/")
public class CursoController {

	// IoC
	@Autowired
	private CursoDAO cursoDAO;

	// "/cursos"
	@RequestMapping(value="cursos", method=RequestMethod.GET)
	public ResponseEntity<List<Curso>> list() {
		List<Curso> cursos = cursoDAO.list();
        if (cursos.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Curso>>(cursos, HttpStatus.OK);
	}

	// "/curso/{id}"
	@RequestMapping(value="cursos/{id}", method=RequestMethod.GET)
	public ResponseEntity<Curso> find(@PathVariable("id") Long id) {
		Curso curso = cursoDAO.find(id);
		if (curso == null)
			return new ResponseEntity<Curso>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<Curso>(curso, HttpStatus.OK);

	}

	// "/curso"
	public ResponseEntity<?> save(@RequestBody Curso curso) {

		return null;
	}

	// "/curso/{id}"
	public ResponseEntity<?> remove(@PathVariable Long id) {

		return null;

	}

	// "/curso/{id}"
	public ResponseEntity<?> merge(@PathVariable Long id, @RequestBody Curso curso) {

		return null;
	}

}
