package br.com.sbs.walllet.transacao;

import br.com.sbs.walllet.usuario.Usuario;
import lombok.Getter;
import lombok.ToString;

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

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @Deprecated
    public Transacao() {    }

    public Transacao(BigDecimal preco, Integer quantidade, String ticker, TipoTransacao tipoTransacao, Usuario usuario) {
        this.preco = preco;
        this.quantidade = quantidade;
        this.ticker = ticker;
        this.tipoTransacao = tipoTransacao;
        this.usuario = usuario;
    }

    public Transacao(LocalDate data, BigDecimal preco, Integer quantidade, String ticker, TipoTransacao tipoTransacao, Usuario usuario) {
        this(preco, quantidade, ticker, tipoTransacao, usuario);
        this.data = data;
    }

}
