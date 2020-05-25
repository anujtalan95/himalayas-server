package in.himalayas.himalayasserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.himalayas.himalayasserver.entity.SearchTag;

@Repository
public interface SearchTagMasterRepository extends JpaRepository<SearchTag, Long>{

}
