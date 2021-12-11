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

    private TransacaoRepository transacaoRepository;

    public TransacaoController(TransacaoRepository transacaoRepository) {
        this.transacaoRepository = transacaoRepository;
    }

    @GetMapping
    public ResponseEntity<List<TransacaoDTO>> list() {
        List<Transacao> transacoes = transacaoRepository.findAll();
        return ResponseEntity.ok().body(TransacaoDTO.fromEntity(transacoes));
    }

    @PostMapping
    public ResponseEntity<Void> cadastrar(@RequestBody @Valid NewTransacaoForm transacaoForm) {
        Transacao transacao = transacaoForm.toEntity();
        transacaoRepository.save(transacao);
        URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/{id}").buildAndExpand(transacao.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
