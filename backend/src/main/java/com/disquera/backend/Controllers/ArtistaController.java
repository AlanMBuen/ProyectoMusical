package com.disquera.backend.Controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.disquera.backend.Dto.ArtistaDTO;
import com.disquera.backend.Models.Artista;
import com.disquera.backend.Service.ArtistaService;

@RestController
@RequestMapping("api/artistas")
public class ArtistaController {
    private final ArtistaService artistaService;

    public ArtistaController(ArtistaService artistaService){
        this.artistaService=artistaService;
    }

    @GetMapping("")
    public ResponseEntity<List<Artista>> obtenertodos(){
        List<Artista> todos = artistaService.obtenertodos();
        return ResponseEntity.ok(todos);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Artista> obtenerxid(@PathVariable Long id){
        Artista idn = artistaService.obtenerxid(id);
        return ResponseEntity.ok(idn);
    }

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<List<Artista>> obtenerxnombre(@PathVariable String nombre){
        List<Artista> lista = artistaService.obtenerxnombre(nombre);
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/genero/{genero}")
    public ResponseEntity<List<Artista>> obtenerxgenero(@PathVariable String genero){
        List<Artista> lista = artistaService.obtenerxgenero(genero);
        return ResponseEntity.ok(lista);
    }

    @PostMapping("/crear")
    public ResponseEntity<Artista> crearartista(@RequestBody ArtistaDTO dtoartista){
        Artista nuevo = artistaService.crearArtista(dtoartista);
        return ResponseEntity.ok(nuevo);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<Artista> editarartista(@PathVariable Long id, @RequestBody ArtistaDTO dtoartista){
        Artista edicion = artistaService.editarArtista(dtoartista, id);
        return ResponseEntity.ok(edicion);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarartista(@PathVariable Long id){
        artistaService.eliminarArtista(id);
        return ResponseEntity.noContent().build();
    }
}
