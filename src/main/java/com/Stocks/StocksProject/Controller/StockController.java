package com.Stocks.StocksProject.Controller;


import com.Stocks.StocksProject.Entity.Stock;
import com.Stocks.StocksProject.Exception.StockNotFoundException;
import com.Stocks.StocksProject.Service.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1")
public class StockController {


    private final StockService stockService;

    @GetMapping("/getAllStocks")
    public ResponseEntity<List<Stock>> getAllStocks(){
        List<Stock> allStocks = stockService.getAllStocks();
        return new ResponseEntity<>(allStocks, HttpStatus.OK);
    }

    @GetMapping("/getStock/{id}")
    public ResponseEntity<Stock> getStock(@PathVariable int id){
        Stock st = stockService.getStockById(id);
        if(st== null) throw  new StockNotFoundException("Stock Not Found");
        return new ResponseEntity<>(st, HttpStatus.OK);
    }

    @PostMapping("/getByCategory")
    public ResponseEntity< Map<String, List<Stock>>> getByCategory(@RequestBody String category){
        Map<String, List<Stock>> stockByCategory = stockService.getStockByCategory(category);
        return new ResponseEntity<>(stockByCategory, HttpStatus.OK);
    }

    @PutMapping("/updateStock")
    public ResponseEntity<Stock> updateStock(@RequestBody Stock stock){
        Stock updatedStock1= stockService.updateStock(stock);
        return new ResponseEntity<>(updatedStock1, HttpStatus.OK);
    }

    @DeleteMapping("/deleteStock")
    public ResponseEntity<String> deleteStock(@RequestBody int id){
        boolean deletedstock= stockService.deleteStockById(id);

        return  (deletedstock) ?
                     new ResponseEntity<>("Stock is removed succesfully!!",HttpStatus.OK)
                    :  new ResponseEntity<>("Invalid request!!",HttpStatus.OK);
    }


    @PostMapping("/addStocks")
    public ResponseEntity<List<Stock>> addStocks(@RequestBody List<Stock> stocks){
        List<Stock> addStocksList = stockService.addStocks(stocks);
        return new ResponseEntity<>(addStocksList, HttpStatus.CREATED);
    }

    @PostMapping("/addStock")
    public ResponseEntity<Stock> addStocks(@RequestBody Stock stock){
        Stock addSingleStock = stockService.addStock(stock);
        return new ResponseEntity<>(addSingleStock, HttpStatus.CREATED);
    }



}
