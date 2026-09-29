package portafolio_joelgarcia.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import portafolio_joelgarcia.demo.domain.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}