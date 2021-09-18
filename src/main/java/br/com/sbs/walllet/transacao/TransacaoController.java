package br.com.sbs.walllet.transacao;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/transacoes")
public class TransacaoController {

    private List<Transacao> transacoes = new ArrayList<>();

    @GetMapping
    public ResponseEntity<List<TransacaoDTO>> list() {
        return ResponseEntity.ok().body(TransacaoDTO.fromEntity(transacoes));
    }

    @PostMapping
    public void cadastrar(@RequestBody NewTransacaoForm transacaoForm) {
        Transacao transacao = transacaoForm.toEntity();
        transacoes.add(transacao);
    }
}
