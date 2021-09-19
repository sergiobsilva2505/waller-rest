package br.com.sbs.walllet.transacao;

import lombok.Getter;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
public class NewTransacaoForm {

    @PastOrPresent
    private LocalDate data;
    @NotNull
    private BigDecimal preco;
    @NotNull
    private Integer quantidade;
    @NotBlank
    @Size(min = 5, max = 6)
    private String ticker;
    @NotNull
    private TipoTransacao tipoTransacao;

    @Deprecated
    public NewTransacaoForm() {
    }

    public Transacao toEntity(){
        return new Transacao(data, preco, quantidade, ticker, tipoTransacao);
    }


}
