package cz.metait.lundegaard.repository;

import cz.metait.lundegaard.model.RequestType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RequestTypeRepository extends JpaRepository<RequestType, Long> {

  Optional<RequestType> getByName(String name);
}
