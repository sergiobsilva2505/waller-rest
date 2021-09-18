package br.com.sbs.walllet.controller;

import br.com.sbs.walllet.transacao.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/transacoes")
public class TransacaoController {

    private List<Transacao> transacoes = new ArrayList<>();

    @GetMapping
    public ResponseEntity<List<Transacao>> list() {
        return ResponseEntity.ok().body(transacoes);
    }

    @PostMapping
    public void cadastrar(@RequestBody Transacao form) {
        transacoes.add(form);
    }
}
