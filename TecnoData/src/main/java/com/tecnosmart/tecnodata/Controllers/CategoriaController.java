package com.tecnosmart.tecnodata.controllers;

import com.tecnosmart.tecnodata.models.Categoria;
import com.tecnosmart.tecnodata.services.CategoriaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/categorias")
public class CategoriaController {

    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    // Leer: Listar todas las categorías
    @GetMapping
    public String listarCategorias(Model model) {
        model.addAttribute("categorias", categoriaService.listarCategorias());
        return "categorias/listar"; // Asegúrate de que esta vista exista
    }

    // Crear: Mostrar formulario para una nueva categoría
    @GetMapping("/nuevo")
    public String mostrarFormularioNuevaCategoria(Model model) {
        model.addAttribute("categoria", new Categoria());
        return "categorias/nuevo"; // Vista para crear una nueva categoría
    }

    // Crear: Guardar la nueva categoría
    @PostMapping
    public String guardarCategoria(@ModelAttribute("categoria") Categoria categoria) {
        categoriaService.guardar(categoria);
        return "redirect:/categorias"; // Redirigir a la lista de categorías
    }

    // Leer: Ver una categoría por ID
    @GetMapping("/{id}")
    public String verCategoria(@PathVariable Long id, Model model) {
        Optional<Categoria> categoria = categoriaService.obtenerCategoriaPorId(id);
        if (categoria.isPresent()) {
            model.addAttribute("categoria", categoria.get());
            return "categorias/ver"; // Vista para mostrar los detalles de una categoría
        } else {
            return "redirect:/categorias"; // Redirigir si la categoría no existe
        }
    }

    // Actualizar: Mostrar formulario para editar una categoría
    @GetMapping("/{id}/editar")
    public String mostrarFormularioEditarCategoria(@PathVariable Long id, Model model) {
        Optional<Categoria> categoria = categoriaService.obtenerCategoriaPorId(id);
        if (categoria.isPresent()) {
            model.addAttribute("categoria", categoria.get());
            return "categorias/editar"; // Vista para editar una categoría
        } else {
            return "redirect:/categorias"; // Redirigir si la categoría no existe
        }
    }

    // Actualizar: Guardar cambios en la categoría
    @PostMapping("/{id}")
    public String actualizarCategoria(@PathVariable Long id, @ModelAttribute("categoria") Categoria categoria) {
        categoria.setId(id); // Asegurarse de que la actualización afecta a la categoría correcta
        categoriaService.guardar(categoria);
        return "redirect:/categorias"; // Redirigir a la lista de categorías
    }

    // Eliminar: Eliminar una categoría
    @GetMapping("/{id}/eliminar")
    public String eliminarCategoria(@PathVariable Long id) {
        categoriaService.obtenerCategoriaPorId(id).ifPresent(categoria -> categoriaService.eliminar(categoria.getId()));
        return "redirect:/categorias"; // Redirigir a la lista de categorías
    }
}
