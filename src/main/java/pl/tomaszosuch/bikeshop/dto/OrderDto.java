package pl.tomaszosuch.bikeshop.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class OrderDto {

    private final Long id;
    private final LocalDateTime orderDate;
    private final String comments;
    private final BigDecimal totalValue;
    private final boolean isCompleted;
}
