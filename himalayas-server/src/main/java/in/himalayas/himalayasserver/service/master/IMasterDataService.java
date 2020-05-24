package in.himalayas.himalayasserver.service.master;

import java.util.List;

import in.himalayas.himalayasserver.entity.MasterData;

public interface IMasterDataService {
	public void save(MasterData masterData);
	public List<MasterData> findAll();
	public MasterData getOne(long id);
	public void deleteById(Long id);
	public void updateMaster(MasterData masterDate, Long id);
}
