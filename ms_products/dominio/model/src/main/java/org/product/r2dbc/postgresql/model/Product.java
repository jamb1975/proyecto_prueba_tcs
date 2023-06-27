package org.product.r2dbc.postgresql.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;

@Data
@Builder(toBuilder = true)
@Table(name = "products")
public class Product {
    @Id
    @Column(value = "ID")
    private Integer id;
    @Column(value = "NOMBRE")
    private String nombre;
    @Column(value = "PRECIO")
    private BigDecimal precio;

}
