package in.himalayas.himalayasserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.himalayas.himalayasserver.entity.MasterData;

@Repository
public interface MasterRepository extends JpaRepository<MasterData, Long>{

}
