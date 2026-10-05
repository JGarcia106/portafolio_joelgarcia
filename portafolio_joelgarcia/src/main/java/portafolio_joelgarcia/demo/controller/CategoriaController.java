package portafolio_joelgarcia.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import portafolio_joelgarcia.demo.domain.Categoria;
import portafolio_joelgarcia.demo.service.CategoriaService;

@Controller
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/categoria/listado")
    public String listado(Model model) {
        var categorias = categoriaService.getCategorias(false);

        model.addAttribute("categorias", categorias);
        model.addAttribute("totalCategorias", categorias.size());
        model.addAttribute("categoria", new Categoria());

        return "/categoria/listado";
    }

    @GetMapping("/categoria/nuevo")
    public String categoriaNuevo(Categoria categoria) {
        return "/categoria/modifica";
    }

    @PostMapping("/categoria/guardar")
    public String categoriaGuardar(
            Categoria categoria,
            @RequestParam("imagenFile") MultipartFile imagenFile) {

        categoriaService.save(categoria, imagenFile);

        return "redirect:/categoria/listado";
    }

    @GetMapping("/categoria/modificar/{idCategoria}")
    public String categoriaModificar(
            Categoria categoria,
            Model model) {

        categoria = categoriaService.getCategoria(categoria);

        model.addAttribute("categoria", categoria);

        return "/categoria/modifica";
    }

    @PostMapping("/categoria/eliminar")
    public String categoriaEliminar(
            @RequestParam("idCategoria") Long idCategoria) {

        Categoria categoria = new Categoria();
        categoria.setIdCategoria(idCategoria);

        categoriaService.delete(categoria);

        return "redirect:/categoria/listado";
    }
}