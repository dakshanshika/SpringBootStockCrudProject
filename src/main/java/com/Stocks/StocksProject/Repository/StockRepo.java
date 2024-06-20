package com.Stocks.StocksProject.Repository;

import com.Stocks.StocksProject.Entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StockRepo extends JpaRepository<Stock, Integer> {


    public List<Stock> findByCategory(String category);


}
