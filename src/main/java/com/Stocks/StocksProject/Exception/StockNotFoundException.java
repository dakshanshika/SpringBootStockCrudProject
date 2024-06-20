package com.Stocks.StocksProject.Exception;

public class StockNotFoundException extends RuntimeException{

    public StockNotFoundException(String msg){
        super(msg);
    }
}
