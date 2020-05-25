package in.himalayas.himalayasserver.service.master;

import java.util.List;

import in.himalayas.himalayasserver.entity.SearchTag;

public interface ISearchTagMasterService {
	public void save(SearchTag searchTag);
	public List<SearchTag> findAll();
	public SearchTag getOne(long id);
	public void deleteById(Long id);
	public void updateMaster(SearchTag searchTag, Long id);
}
