package com.Stocks.StocksProject.Service;

import com.Stocks.StocksProject.Entity.Stock;
import java.util.List;
import java.util.Map;

public interface StockService {

    public List<Stock> getAllStocks();

    public Stock getStockById(int id);

    public List<Stock> addStocks(List<Stock> stocks);

    public Stock addStock(Stock stock);

    public Stock updateStock(Stock stock);

    public boolean deleteStockById(int id);

    public Map<String, List<Stock>> getStockByCategory(String category);
}
