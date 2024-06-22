package com.Stocks.StocksProject.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int code;
    @Column(nullable = false, unique = true)
    private String name;
    @Column(nullable = false)
    private String category;
    private  double ltp;

    @ColumnDefault("NSE")
    private String exchange;

}
