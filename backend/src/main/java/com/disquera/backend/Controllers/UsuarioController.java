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

import com.disquera.backend.Dto.UsuarioDTO;
import com.disquera.backend.Models.RolUsuario;
import com.disquera.backend.Models.Usuario;
import com.disquera.backend.Service.UsuarioService;

@RestController
@RequestMapping("api/usuarios")
public class UsuarioController {
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService){
        this.usuarioService=usuarioService;
    }

    @GetMapping("")
    public ResponseEntity<List<Usuario>> obtenertodos (){
        List<Usuario> lista = usuarioService.obtenertodos();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Usuario> obtenerxid(@PathVariable Long id){
        Usuario idn = usuarioService.obtenerxid(id);
        return ResponseEntity.ok(idn);
    }

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<Usuario> obtenerxnombre(@PathVariable String nombre){
        Usuario lista = usuarioService.obtenerxnombre(nombre);
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/rol/{rol}")
    public ResponseEntity<List<Usuario>> obtenerxplan(@PathVariable RolUsuario rol){
        List<Usuario> lista = usuarioService.obtenerxrol(rol);
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/perfil/{id}")
    public ResponseEntity<List<Usuario>> obtenerxperfil(@PathVariable Long id){
        List<Usuario> idn = usuarioService.obtenerxperfil(id);
        return ResponseEntity.ok(idn);
    }

    @PostMapping("/crear")
    public ResponseEntity<Usuario> crearusuariocomun(@RequestBody UsuarioDTO dtousuario){
        Usuario crear = usuarioService.crearusuario(dtousuario);
        return ResponseEntity.ok(crear);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<Usuario> editarusuariocomun(@PathVariable Long id, @RequestBody UsuarioDTO dtousuario){
        Usuario editar = usuarioService.editarusuario(dtousuario, id);
        return ResponseEntity.ok(editar);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarusuariocomun(@PathVariable Long id){
        usuarioService.eliminarusuario(id);
        return ResponseEntity.noContent().build();
    }
    
}
