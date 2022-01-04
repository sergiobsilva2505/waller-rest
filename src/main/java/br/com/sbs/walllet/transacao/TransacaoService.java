package br.com.sbs.walllet.transacao;

import br.com.sbs.walllet.usuario.Usuario;
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
       return transacaoRepository.save(transacao);
    }

    public Transacao toEntity(NewTransacaoForm transacaoForm, Usuario usuario) {
        return new Transacao(transacaoForm.data(), transacaoForm.preco(), transacaoForm.quantidade(), transacaoForm.ticker(), transacaoForm.tipoTransacao(), usuario);
    }
}
