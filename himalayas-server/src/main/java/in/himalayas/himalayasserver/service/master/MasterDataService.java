package in.himalayas.himalayasserver.service.master;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.himalayas.himalayasserver.entity.MasterData;
import in.himalayas.himalayasserver.repository.MasterRepository;

@Transactional
@Service("masterDataService")
public class MasterDataService implements IMasterDataService {

	@Autowired
	protected MasterRepository masterRepository;
	
	public void save(MasterData masterData) {
		masterRepository.save(masterData);
	}
	
	public List<MasterData> findAll() {
		return masterRepository.findAll();
	}
	
	public MasterData getOne(long id) {
		return masterRepository.getOne(id);
	}
	
	public void deleteById(Long id) {
		masterRepository.deleteById(id);
	}
	
	public void updateMaster(MasterData masterDate, Long id) {
		Optional<MasterData> optional = masterRepository.findById(id);
		MasterData oldMasterData = null;
		if (optional.get() != null) {
			oldMasterData = optional.get();
			setMasterData(masterDate,oldMasterData);
		}
		masterRepository.save(oldMasterData);
	}
	
	public void setMasterData(MasterData newMasterData,MasterData oldMasterData) {
		oldMasterData.setCode(newMasterData.getCode());
		oldMasterData.setName(newMasterData.getName());
		oldMasterData.setStatus(newMasterData.getStatus());
	}
}
