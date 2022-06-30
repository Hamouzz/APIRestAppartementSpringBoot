/**
 * 
 */
package com.example.appartement.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.appartement.exception.ResourceNotFoundException;
import com.example.appartement.model.Appartement;
import com.example.appartement.repository.AppartementRepository;

/**
 * @author User
 *
 */


@RestController
@RequestMapping("/api/v1")
public class AppartementController {
	
	private static Logger Logger = LoggerFactory.getLogger(AppartementController.class);
	
	
	@Resource
	private AppartementRepository appartementRepository;
	
	@GetMapping("/appartements")
	public List<Appartement> getAllAppartements() {
		Logger.info("Trouve tout les appartements");
		return appartementRepository.findAll();
	}
	
	@GetMapping("/appartements/{id}")
	public ResponseEntity<Appartement> getAppartementById(@PathVariable(value = "id") String id) throws ResourceNotFoundException {
		
		Appartement appartement = appartementRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Appartement non trouvé pour cet id :: " + id));
		
		Logger.info("Trouve un Appartement avec pour id : {}", id);
		return ResponseEntity.ok().body(appartement);
	}
	
	@PostMapping(path = "/appartements")
	public ResponseEntity<Appartement> createAppartement(@RequestBody Appartement appartement) throws ResourceNotFoundException {
		
		Appartement newAppartement = appartementRepository.save(appartement);
		
		Logger.info("Creer un appartement avec pour id : {}", newAppartement.getId());
		return new ResponseEntity<>(newAppartement, HttpStatus.CREATED);
	}
	
	@PutMapping("/appartements/{id}")
	public ResponseEntity<Appartement> updateAppartement(@PathVariable("id") String id, @RequestBody Appartement appartement) throws ResourceNotFoundException {
		
		Appartement appartementData = appartementRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Appartement non trouvé pour cet id :: " + id));
		
		appartementData.setSupperficie(appartement.getSupperficie());
		appartementData.setNumero(appartement.getNumero());
		appartementData.setAdresse(appartement.getAdresse());
		appartementData.setType(appartement.getType());
		appartementData.setMeuble(appartement.getMeuble());
		
		Appartement updatedAppartement = appartementRepository.save(appartementData);
		
		Logger.info("Appartement update avec pour id : {}", id);
		return new ResponseEntity<>(updatedAppartement, HttpStatus.OK);
	}
	
	@DeleteMapping("/appartements/{id}")
	public Map<String, Boolean> deleteAppartement(@PathVariable("id") String id) throws ResourceNotFoundException {
		
		Appartement appartement = appartementRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Appartement non trouvé pour cet id :: " + id));
		
		appartementRepository.delete(appartement);
		
		Logger.info("Supprime l'Appartement avec pour id : {}", id);
		Map<String, Boolean> response = new HashMap<>();
		response.put("L'appartement a été supprimé !", Boolean.TRUE);
		
		return response;
	}

}
