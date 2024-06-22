package com.Stocks.StocksProject.Service.Impl;

import com.Stocks.StocksProject.Entity.Stock;
import com.Stocks.StocksProject.Repository.StockRepo;
import com.Stocks.StocksProject.Service.StockService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class StockServiceImpl implements StockService {



    private final StockRepo stockRepo;



    @Override
    public List<Stock> getAllStocks() {
        log.info("getAllStocks() started...");
        List<Stock> all = stockRepo.findAll();
        log.info("getAllStocks() ended...");

        return all;
    }

    @Override
    public Stock getStockById(int id) {
        Optional<Stock> byId = stockRepo.findById(id);
        return byId.orElse(null);
    }

    @Override
    public Map<String, List<Stock>> getStockByCategory(String category){
        List<Stock> byCategory = stockRepo.findByCategory(category);
        Map<String, List<Stock>> mapByCateogry = byCategory.stream().collect(Collectors.groupingBy(Stock::getCategory, Collectors.toList()));
        return mapByCateogry;
    }

    @Override
    public List<Stock> addStocks(List<Stock> stocks) {
        return stockRepo.saveAll(stocks);
    }

    @Override
    public Stock addStock(Stock stock) {
        return stockRepo.save(stock);
    }

    @Override
    public Stock updateStock(Stock stock) {
        Stock existStock = getStockById(stock.getCode());
        if(existStock!=null){
            existStock.setName(stock.getName()!=null? stock.getName(): existStock.getName());
            existStock.setCategory(stock.getCategory()!=null? stock.getCategory(): existStock.getCategory());
            existStock.setLtp(stock.getLtp()!=existStock.getLtp()? stock.getLtp(): existStock.getLtp());
            stockRepo.save(existStock);
        }

        return existStock;

    }

    @Override
    public boolean deleteStockById(int id) {
        Stock existStock = getStockById(id);

        if(existStock!=null)  {
            stockRepo.delete(existStock);
            return  true;
        }
        return  false;
    }

}
