package curso.springboot.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import curso.springboot.model.Membro;

@Repository
@Transactional
public interface MembroRepository extends CrudRepository<Membro, Long> {}
