package br.com.sbs.walllet.transacao;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public record NewTransacaoForm(
        @PastOrPresent LocalDate data,
        @NotNull BigDecimal preco,
        @NotNull Integer quantidade,
        @NotBlank @Size(min = 5, max = 6)String ticker,
        @NotNull TipoTransacao tipoTransacao) {

    public Transacao toEntity(){
        return new Transacao(data, preco, quantidade, ticker,  tipoTransacao);
    }
}
