package in.himalayas.himalayasserver.service.master;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.himalayas.himalayasserver.entity.SearchTag;
import in.himalayas.himalayasserver.repository.SearchTagMasterRepository;

@Transactional
@Service("searchTagMasterService")
public class SearchTagMasterService implements ISearchTagMasterService {

	@Autowired
	protected SearchTagMasterRepository searchTagMasterRepository;
	
	public void save(SearchTag searchTag) {
		searchTagMasterRepository.save(searchTag);
	}
	
	public List<SearchTag> findAll() {
		return searchTagMasterRepository.findAll();
	}
	
	public SearchTag getOne(long id) {
		return searchTagMasterRepository.getOne(id);
	}
	
	public void deleteById(Long id) {
		searchTagMasterRepository.deleteById(id);
	}
	
	public void updateMaster(SearchTag searchTag, Long id) {
		Optional<SearchTag> optional = searchTagMasterRepository.findById(id);
		SearchTag oldTagMasterData = null;
		if (optional.get() != null) {
			oldTagMasterData = optional.get();
			setMasterData(searchTag,oldTagMasterData);
		}
		searchTagMasterRepository.save(oldTagMasterData);
	}
	
	public void setMasterData(SearchTag newTagMasterData,SearchTag oldTagMasterData) {
		oldTagMasterData.setCode(newTagMasterData.getCode());
		oldTagMasterData.setName(newTagMasterData.getName());
		oldTagMasterData.setStatus(newTagMasterData.isStatus());
	}
}
