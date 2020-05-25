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

import in.himalayas.himalayasserver.entity.SearchTag;
import in.himalayas.himalayasserver.service.master.ISearchTagMasterService;

@RestController
@RequestMapping("api/searchtag/master")
public class SearchTagMasterController {
	
	@Autowired
	private ISearchTagMasterService searchTagMasterService;

	@GetMapping
	public List<SearchTag> listAll() {
		return searchTagMasterService.findAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public void create(@RequestBody SearchTag searchTag) {
		searchTagMasterService.save(searchTag);
	}
	
	@GetMapping("/{id}")
	public SearchTag get(@PathVariable("id") long id) {
		return searchTagMasterService.getOne(id);
	}
	
	@DeleteMapping("/{id}/delete")
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable("id") Long id) {
		searchTagMasterService.deleteById(id);
	}
	
	@PutMapping("/{id}/update")
	@ResponseStatus(HttpStatus.OK)
	public void update(@RequestBody SearchTag searchTag, @PathVariable("id") Long id) {
		searchTagMasterService.updateMaster(searchTag, id);
	}
	
}
