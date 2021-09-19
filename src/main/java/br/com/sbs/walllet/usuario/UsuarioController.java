package br.com.sbs.walllet.usuario;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private UsuarioRepository usuarioRepository;
    private UsuarioService usuarioService;

    public UsuarioController(UsuarioRepository usuarioRepository, UsuarioService usuarioService) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> listar() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return ResponseEntity.ok().body(UsuarioDTO.fromEntity(usuarios));
    }

    @PostMapping
    public void cadastrar(@RequestBody @Valid NewUsuarioForm newUsuarioForm) {
        Usuario usuario = newUsuarioForm.toEntity();
        usuarioRepository.save(usuario);
    }
}
