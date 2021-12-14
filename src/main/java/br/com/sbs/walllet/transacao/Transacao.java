package br.com.sbs.walllet.transacao;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@ToString
@Entity
@Table(name = "transacoes")
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate data;
    private BigDecimal preco;
    private Integer quantidade;
    private String ticker;

    @Enumerated(EnumType.STRING)
    private TipoTransacao tipoTransacao;

    @Deprecated
    public Transacao() {    }

    public Transacao(BigDecimal preco, Integer quantidade, String ticker, TipoTransacao tipoTransacao) {
        this.preco = preco;
        this.quantidade = quantidade;
        this.ticker = ticker;
        this.tipoTransacao = tipoTransacao;
    }

    public Transacao(LocalDate data, BigDecimal preco, Integer quantidade, String ticker, TipoTransacao tipoTransacao) {
        this(preco, quantidade, ticker, tipoTransacao);
        this.data = data;
    }

}
