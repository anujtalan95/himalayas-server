package in.himalayas.himalayasserver.web.controller.master;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import in.himalayas.himalayasserver.entity.MasterData;
import in.himalayas.himalayasserver.service.master.IMasterDataService;

@RestController
@RequestMapping("api/master")
public class MasterDataController {
	
	@Autowired
	private IMasterDataService masterDataService;

	@GetMapping
	public List<MasterData> listAll() {
		return masterDataService.findAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public void create(@RequestBody MasterData masterData) {
		masterDataService.save(masterData);
	}
	
	@GetMapping("/{id}")
	public MasterData get(@PathVariable("id") long id) {
		return masterDataService.getOne(id);
	}
	
	@DeleteMapping("/{id}/delete")
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable("id") Long id) {
		masterDataService.deleteById(id);
	}
	
	@PutMapping("/{id}/update")
	@ResponseStatus(HttpStatus.OK)
	public void update(@RequestBody MasterData masterData, @PathVariable("id") Long id) {
		masterDataService.updateMaster(masterData, id);
	}
	
}
