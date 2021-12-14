package br.com.sbs.walllet.usuario;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> listar() {
        List<Usuario> usuarios = usuarioService.findAll();
        return ResponseEntity.ok().body(UsuarioDTO.fromEntity(usuarios));
    }

    @PostMapping
    public ResponseEntity<Void> cadastrar(@RequestBody @Valid NewUsuarioForm newUsuarioForm) {
        Usuario usuario = newUsuarioForm.toEntity();
        usuarioService.save(usuario);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(usuario.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }
}
