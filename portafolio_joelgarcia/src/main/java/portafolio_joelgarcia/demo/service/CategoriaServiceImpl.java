package portafolio_joelgarcia.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import portafolio_joelgarcia.demo.domain.Categoria;
import portafolio_joelgarcia.demo.repository.CategoriaRepository;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Categoria> getCategorias(boolean activos) {
        var lista = categoriaRepository.findAll();

        if (activos) {
            lista.removeIf(e -> !e.isActivo());
        }

        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public Categoria getCategoria(Categoria categoria) {
        return categoriaRepository.findById(categoria.getIdCategoria()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Categoria categoria) {
        categoriaRepository.save(categoria);
    }

    @Override
    @Transactional
    public void delete(Categoria categoria) {
        categoriaRepository.delete(categoria);
    }
}