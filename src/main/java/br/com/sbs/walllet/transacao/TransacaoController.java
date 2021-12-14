package br.com.sbs.walllet.transacao;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/transacoes")
public class TransacaoController {

    private final TransacaoService transacaoService;

    public TransacaoController( TransacaoService transacaoService) {
        this.transacaoService = transacaoService;
    }

    @GetMapping
    public ResponseEntity<List<TransacaoDTO>> list() {
        List<Transacao> transacoes = transacaoService.findAll();
        return ResponseEntity.ok().body(TransacaoDTO.fromEntity(transacoes));
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody @Valid NewTransacaoForm transacaoForm) {
        Transacao transacao = transacaoForm.toEntity();
        transacaoService.save(transacao);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(transacao.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
