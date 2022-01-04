package br.com.sbs.walllet.transacao;

import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Getter
public class TransacaoDTO {

    private LocalDate data;
    private BigDecimal preco;
    private Integer quantidade;
    private String ticker;
    private TipoTransacao tipoTransacao;
    private Long usuario_id;

    @Deprecated
    public TransacaoDTO() {
    }

    public TransacaoDTO(Transacao transacao) {
        this.data = transacao.getData();
        this.preco = transacao.getPreco();
        this.quantidade = transacao.getQuantidade();
        this.ticker = transacao.getTicker();
        this.tipoTransacao = transacao.getTipoTransacao();
        this.usuario_id = transacao.getUsuario().getId();
    }

    public static List<TransacaoDTO> fromEntity(List<Transacao> transacoes) {
        return transacoes.stream().map(TransacaoDTO::new).toList();
    }

}
