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

import com.disquera.backend.Dto.AlbumDTO;
import com.disquera.backend.Models.Album;
import com.disquera.backend.Service.AlbumService;

@RestController
@RequestMapping("api/albumes")
public class AlbumController {
    private final AlbumService albumService;

    public AlbumController(AlbumService albumService){
        this.albumService=albumService;
    }

    @GetMapping("")
    public ResponseEntity<List<Album>> obtenertodos(){
        List<Album> lista = albumService.buscartodos();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Album> obtenerxid(@PathVariable Long id){
        Album idn = albumService.buscarxid(id);
        return ResponseEntity.ok(idn);
    }

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<List<Album>> obtenerxnombre(@PathVariable String nombre){
        List<Album> lista = albumService.buscarxnombre(nombre);
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/estreno/{estreno}")
    public ResponseEntity<List<Album>> obtenerxestreno(@PathVariable int estreno){
        List<Album> lista = albumService.buscarxestreno(estreno);
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/artista/{id}")
    public ResponseEntity<List<Album>> obtenerxartista(@PathVariable Long id){
        List<Album> lista = albumService.buscarxartista(id);
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/cancion/{id}")
    public ResponseEntity<List<Album>> obtenerxcancion(@PathVariable Long id){
        List<Album> lista = albumService.buscarxcancion(id);
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/disquera/{id}")
    public ResponseEntity<List<Album>> obtenerxdisquera(@PathVariable Long id){
        List<Album> lista = albumService.buscarxdisquera(id);
        return ResponseEntity.ok(lista);
    }

    @PostMapping("/crear")
    public ResponseEntity<Album> crearalbum(@RequestBody AlbumDTO dtoalbum){
        Album nuevo = albumService.crearalbum(dtoalbum);
        return ResponseEntity.ok(nuevo);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<Album> editaralbum(@PathVariable Long id, @RequestBody AlbumDTO dtoalbum){
        Album edicion = albumService.editaralbum(dtoalbum, id);
        return ResponseEntity.ok(edicion);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminaralbum(@PathVariable Long id){
        albumService.eliminarartista(id);
        return ResponseEntity.noContent().build();
    }
    
}
