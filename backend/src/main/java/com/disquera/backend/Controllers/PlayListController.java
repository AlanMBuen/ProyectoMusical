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

import com.disquera.backend.Dto.PlayListDTO;
import com.disquera.backend.Models.PlayList;
import com.disquera.backend.Service.PlayListService;

@RestController
@RequestMapping("api/playlists")
public class PlayListController {
    private final PlayListService playListService;

    public PlayListController(PlayListService playListService){
        this.playListService=playListService;
    }

    @GetMapping("")
    public ResponseEntity<List<PlayList>> obtenertodos(){
        List<PlayList> lista = playListService.obtenertodos();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<PlayList> obtenerxid(@PathVariable Long id){
        PlayList idn = playListService.obtenerxid(id);
        return ResponseEntity.ok(idn);
    }

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<List<PlayList>> obtenerxnombre(@PathVariable String nombre){
        List<PlayList> lista = playListService.obtenerxnombre(nombre);
        return ResponseEntity.ok(lista);
    }

    @PostMapping("/crear")
    public ResponseEntity<PlayList> crearplaylist(@RequestBody PlayListDTO dtoplaylist){
        PlayList crear = playListService.crearplaylist(dtoplaylist);
        return ResponseEntity.ok(crear);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<PlayList> editarplaylist(@PathVariable Long id, @RequestBody PlayListDTO dtoplaylist){
        PlayList editar = playListService.editarplaylist(dtoplaylist, id);
        return ResponseEntity.ok(editar);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarplaylist(@PathVariable Long id){
        playListService.eliminarplaylist(id);
        return ResponseEntity.noContent().build();
    }
}
