package br.senac.requestfood.controller.additionalItem;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.senac.requestfood.dto.addicionalitem.AdditionalItemDTO;
import br.senac.requestfood.projection.addicionalItem.AdditionalItemProjection;
import br.senac.requestfood.service.additionalitem.AdditionalItemService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/additionalitem")

public class AdditionalItemController {
    
	private final AdditionalItemService additionalItemService;

	public AdditionalItemController(AdditionalItemService additionalItemService) {
		this.additionalItemService = additionalItemService;
	}

	@PostMapping
	public ResponseEntity<AdditionalItemDTO> addAdditionalItem(@RequestBody AdditionalItemDTO additionalItemDTO) {
		return ResponseEntity.status(HttpStatus.CREATED).body(additionalItemService.save(additionalItemDTO));
	}

	@PutMapping("/{id}")
	public ResponseEntity<String> updatedAdditionalItem(@RequestBody AdditionalItemDTO additionalItemDTO, @PathVariable(value = "id") Long id) {
		additionalItemService.update(additionalItemDTO, id);
		return ResponseEntity.status(HttpStatus.OK).body("Additional Item update successfully");
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deletedAdditionalItem(@PathVariable(value = "id") Long id) {
		additionalItemService.delete(id);
		return ResponseEntity.status(HttpStatus.OK).body("Additional Item deleted successfully");
	}

	@GetMapping("/{id}")
	public ResponseEntity<AdditionalItemProjection> getAdditionalItem(@PathVariable(value = "id") Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(additionalItemService.findById(id));
	}

	@GetMapping()
	public ResponseEntity<List<AdditionalItemProjection>> getAllAddictionalItem() {
		return ResponseEntity.status(HttpStatus.OK).body(additionalItemService.findAll());
	}
}
