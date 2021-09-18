package br.com.sbs.walllet.transacao;

import com.fasterxml.jackson.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class TransacaoDTO {

    @JsonProperty
    private LocalDate data;

    @JsonProperty
    private BigDecimal preco;

    @JsonProperty
    private Integer quantidade;

    @JsonProperty
    private String ticker;

    @JsonProperty
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

    public static List<TransacaoDTO> fromEntity(List<Transacao> transacaos){
        return transacaos.stream().map(TransacaoDTO::new).toList();
    }

}
