package br.com.sbs.walllet.transacao;

import br.com.sbs.walllet.usuario.Usuario;
import br.com.sbs.walllet.usuario.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/transacoes")
public class TransacaoController {

    private final TransacaoService transacaoService;
    private final UsuarioService usuarioService;

    public TransacaoController(TransacaoService transacaoService, UsuarioService usuarioService) {
        this.transacaoService = transacaoService;
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public ResponseEntity<List<TransacaoDTO>> list() {
        List<Transacao> transacoes = transacaoService.findAll();
        return ResponseEntity.ok().body(TransacaoDTO.fromEntity(transacoes));
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody @Valid NewTransacaoForm transacaoForm) {
        Usuario usuario = usuarioService.findById(transacaoForm.usuario_id())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        Transacao transacao = transacaoService.toEntity(transacaoForm, usuario);

        transacaoService.save(transacao);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(transacao.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

}
