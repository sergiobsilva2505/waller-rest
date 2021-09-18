package br.com.sbs.walllet.transacao;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class NewTransacaoForm {

    @JsonProperty("data")
    private LocalDate data;

    @JsonProperty("preco")
    private BigDecimal preco;

    @JsonProperty("quantidade")
    private Integer quantidade;

    @JsonProperty("ticker")
    private String ticker;

    @JsonProperty("tipoTransacao")
    private TipoTransacao tipoTransacao;

    @Deprecated
    public NewTransacaoForm() {
    }

    public Transacao toEntity(){
        return new Transacao(data, preco, quantidade, ticker, tipoTransacao);
    }


}
