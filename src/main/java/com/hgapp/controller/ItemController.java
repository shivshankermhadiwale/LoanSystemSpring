package com.hgapp.controller;
/*package com.dsoft.controller;

import java.util.stream.Collectors;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dsoft.entity.Item;

@RestController
@RequestMapping("/item")
public class ItemController extends ControllerManager {
	private static final Logger logger = LogManager.getLogger(ItemController.class);

	@PostMapping("/addNew")
	public final ResponseEntity<?> createNewItem(@Valid Item item, Errors errors) {
		logger.info("Adding New Item Process Begins------");
		if (errors.hasErrors())
			return ResponseEntity.ok(
					errors.getAllErrors().stream().map(data -> data.getDefaultMessage()).collect(Collectors.toList()));
		return new ResponseEntity<>(this.getServiceManager().getItemService().addNewItem(item), HttpStatus.ACCEPTED);

	}

	@GetMapping("/findItem/{itemId}")
	public ResponseEntity<?> getItemById(@PathVariable Long itemId) {
		logger.info("Finding Item By Id Process Begins------");
		if (itemId == null)
			throw new NullPointerException("Item Id Empty");
		return new ResponseEntity<>(this.getServiceManager().getItemService().findItemById(itemId),
				HttpStatus.ACCEPTED);
	}
}
*/