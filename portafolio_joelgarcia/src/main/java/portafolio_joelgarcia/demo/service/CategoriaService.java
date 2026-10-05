package portafolio_joelgarcia.demo.service;

import java.util.List;
import org.springframework.web.multipart.MultipartFile;
import portafolio_joelgarcia.demo.domain.Categoria;

public interface CategoriaService {

    public List<Categoria> getCategorias(boolean activos);

    public Categoria getCategoria(Categoria categoria);

    public void save(Categoria categoria, MultipartFile imagenFile);

    public void delete(Categoria categoria);

}