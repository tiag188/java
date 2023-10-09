package curso.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import curso.springboot.model.Projeto;

@Repository
@Transactional
public interface ProjetoRepository extends JpaRepository<Projeto, Long> {
  // Implementar consultas personalizadas, se necessário
}
