package br.com.sbs.walllet.transacao;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

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
    public void cadastrar(@RequestBody @Valid NewTransacaoForm transacaoForm) {
        Transacao transacao = transacaoForm.toEntity();
        transacaoRepository.save(transacao);
    }
}
