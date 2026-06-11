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

import com.disquera.backend.Dto.CancionDTO;
import com.disquera.backend.Models.Cancion;
import com.disquera.backend.Service.CancionService;

@RestController
@RequestMapping("api/canciones")
public class CancionController {
    private final CancionService cancionService;

    public CancionController(CancionService cancionService){
        this.cancionService=cancionService;
    }

    @GetMapping("")
    public ResponseEntity<List<Cancion>> obtenertodos (){
        List<Cancion> lista = cancionService.obtenertodos();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Cancion> obtenerxid(@PathVariable Long id){
        Cancion idn = cancionService.obtenerxid(id);
        return ResponseEntity.ok(idn);
    }

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<List<Cancion>> obtenerxnombre(@PathVariable String nombre){
        List<Cancion> lista = cancionService.obtenerxnombre(nombre);
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/genero/{genero}")
    public ResponseEntity<List<Cancion>> obtenerxgenero(@PathVariable String genero){
        List<Cancion> lista = cancionService.obtenerxgenero(genero);
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/duracion/{duracion}")
    public ResponseEntity<List<Cancion>> obtenerxduracion(@PathVariable int duracion){
        List<Cancion> lista = cancionService.obtenerxduracion(duracion);
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/artista/{id}")
    public ResponseEntity<List<Cancion>> obtenerxartista(@PathVariable Long id){
        List<Cancion> lista = cancionService.obtenerxartista(id);
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/album/{id}")
    public ResponseEntity<List<Cancion>> obtenerxalbum(@PathVariable Long id){
        List<Cancion> lista = cancionService.obtenerxalbum(id);
        return ResponseEntity.ok(lista);
    }

    @PostMapping("/crear")
    public ResponseEntity<Cancion> crearcancion(@RequestBody CancionDTO dtocancion){
        Cancion crear = cancionService.crearcancion(dtocancion);
        return ResponseEntity.ok(crear);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<Cancion> editarcancion(@PathVariable Long id, @RequestBody CancionDTO dtocancion){
        Cancion editar = cancionService.editarcancion(dtocancion, id);
        return ResponseEntity.ok(editar);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarcancion(@PathVariable Long id){
        cancionService.eliminarcancion(id);
        return ResponseEntity.noContent().build();
    }
}
