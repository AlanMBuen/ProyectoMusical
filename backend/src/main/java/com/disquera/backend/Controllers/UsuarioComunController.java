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

import com.disquera.backend.Dto.UsuarioComunDTO;
import com.disquera.backend.Dto.UsuarioComunResponseDTO;
import com.disquera.backend.Models.PlanUsuario;
import com.disquera.backend.Models.UsuarioComun;
import com.disquera.backend.Service.UsuarioComunService;

@RestController
@RequestMapping("api/usuarioscomunes")
public class UsuarioComunController {
    private final UsuarioComunService usuarioComunService;

    public UsuarioComunController(UsuarioComunService usuarioComunService){
        this.usuarioComunService=usuarioComunService;
    }

    @GetMapping("")
    public ResponseEntity<List<UsuarioComunResponseDTO>> obtenertodos (){
        List<UsuarioComunResponseDTO> lista = usuarioComunService.obtenertodos();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<UsuarioComunResponseDTO> obtenerxid(@PathVariable Long id){
        UsuarioComunResponseDTO idn = usuarioComunService.obtenerxid(id);
        return ResponseEntity.ok(idn);
    }

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<List<UsuarioComunResponseDTO>> obtenerxnombre(@PathVariable String nombre){
        List<UsuarioComunResponseDTO> lista = usuarioComunService.obtenerxnombre(nombre);
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/plan/{plan}")
    public ResponseEntity<List<UsuarioComunResponseDTO>> obtenerxplan(@PathVariable PlanUsuario plan){
        List<UsuarioComunResponseDTO> lista = usuarioComunService.obtenerxplan(plan);
        return ResponseEntity.ok(lista);
    }

    @PostMapping("/crear")
    public ResponseEntity<UsuarioComunResponseDTO> crearusuariocomun(@RequestBody UsuarioComunDTO dtousuariocomun){
        UsuarioComunResponseDTO crear = usuarioComunService.crearusuariocomun(dtousuariocomun);
        return ResponseEntity.ok(crear);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<UsuarioComunResponseDTO> editarusuariocomun(@PathVariable Long id, @RequestBody UsuarioComunDTO dtousuariocomun){
        UsuarioComunResponseDTO editar = usuarioComunService.editarusuariocomun(dtousuariocomun, id);
        return ResponseEntity.ok(editar);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarusuariocomun(@PathVariable Long id){
        usuarioComunService.eliminarusuariocomun(id);
        return ResponseEntity.noContent().build();
    }
}
