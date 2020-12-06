package br.com.store.register.domain.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class CountResponse implements Serializable {

    private Long id;
    private String name;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private BigDecimal originalValue;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private BigDecimal fixedValue;

    private Integer daysLate;
    private LocalDate payday;

}
