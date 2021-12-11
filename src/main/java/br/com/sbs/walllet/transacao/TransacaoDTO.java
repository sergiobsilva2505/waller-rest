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

    @Deprecated
    public TransacaoDTO() {
    }

    public TransacaoDTO(Transacao transacao) {
        this.data = transacao.getData();
        this.preco = transacao.getPreco();
        this.quantidade = transacao.getQuantidade();
        this.ticker = transacao.getTicker();
        this.tipoTransacao = transacao.getTipoTransacao();
    }

    public static List<TransacaoDTO> fromEntity(List<Transacao> transacaos) {
        return transacaos.stream().map(TransacaoDTO::new).toList();
    }

    public static TransacaoDTO fromEntity(Transacao transacao){
        return new TransacaoDTO(transacao);
    }

}
