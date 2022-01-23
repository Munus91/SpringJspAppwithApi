package com.nmironov.internetshop.dto.customer;


import org.springframework.data.domain.PageRequest;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class GoodFilterDto {

    @NotNull(message = "Min price cannot be Null")
    private final BigDecimal minPrice;
    @NotNull(message = "Max price cannot be Null")
    private final BigDecimal maxPrice;



    private final PageRequest pageRequest;

    public GoodFilterDto(BigDecimal minPrice, BigDecimal maxPrice,
                         PageRequest pageRequest) {
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;

        this.pageRequest = pageRequest;
    }

    public BigDecimal getMinPrice() {
        return minPrice;
    }

    public BigDecimal getMaxPrice() {
        return maxPrice;
    }


    public PageRequest getPageRequest() {
        return pageRequest;
    }


}

