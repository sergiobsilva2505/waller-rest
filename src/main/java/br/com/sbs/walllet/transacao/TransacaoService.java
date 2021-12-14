package br.com.sbs.walllet.transacao;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransacaoService {

    private final TransacaoRepository transacaoRepository;

    public TransacaoService(TransacaoRepository transacaoRepository) {
        this.transacaoRepository = transacaoRepository;
    }

    public List<Transacao> findAll() {
        List<Transacao> transacoes = transacaoRepository.findAll();
        return transacoes;
    }

    public Transacao save(Transacao transacao) {
        Transacao novaTransacao = transacaoRepository.save(transacao);
        return novaTransacao;
    }
}
