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

import com.disquera.backend.Dto.DisqueraDTO;
import com.disquera.backend.Models.Disquera;
import com.disquera.backend.Service.DisqueraService;

@RestController
@RequestMapping("api/disqueras")
public class DisqueraController {
    private final DisqueraService disqueraService;

    public DisqueraController(DisqueraService disqueraService){
        this.disqueraService=disqueraService;
    }

    @GetMapping("")
    public ResponseEntity<List<Disquera>> obtenertodos (){
        List<Disquera> lista = disqueraService.obtenertodos();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Disquera> obtenerxid(@PathVariable Long id){
        Disquera idn = disqueraService.obtenerxid(id);
        return ResponseEntity.ok(idn);
    }

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<List<Disquera>> obtenerxnombre(@PathVariable String nombre){
        List<Disquera> lista = disqueraService.obtenerxnombre(nombre);
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/creacion/{creacion}")
    public ResponseEntity<List<Disquera>> obtenerxcreacion(@PathVariable int creacion){
        List<Disquera> lista = disqueraService.obtenerxcreacion(creacion);
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/albumes/{id}")
    public ResponseEntity<List<Disquera>> obtenerxalbumes(@PathVariable Long id){
        List<Disquera> lista = disqueraService.obtenerxalbumes(id);
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/artistas/{id}")
    public ResponseEntity<List<Disquera>> obtenerxartistas(@PathVariable Long id){
        List<Disquera> lista = disqueraService.obtenerxartistas(id);
        return ResponseEntity.ok(lista);
    }

    @PostMapping("/crear")
    public ResponseEntity<Disquera> creardisquera(@RequestBody DisqueraDTO dtodisquera){
        Disquera crear = disqueraService.creardisquera(dtodisquera);
        return ResponseEntity.ok(crear);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<Disquera> editardisquera(@PathVariable Long id, @RequestBody DisqueraDTO dtodisquera){
        Disquera editar = disqueraService.editardisquera(dtodisquera, id);
        return ResponseEntity.ok(editar);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminardisquera(@PathVariable Long id){
        disqueraService.eliminardisquera(id);
        return ResponseEntity.noContent().build();
    }
}
