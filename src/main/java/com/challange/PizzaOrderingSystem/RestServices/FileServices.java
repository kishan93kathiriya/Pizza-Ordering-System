package com.challange.PizzaOrderingSystem.RestServices;

import com.challange.PizzaOrderingSystem.Model.PizzaOrderVO;

import java.util.List;

public interface FileServices {

    public List<PizzaOrderVO> readData(String filePath) throws Exception;
    public List<PizzaOrderVO> sortData(List<PizzaOrderVO> pizzaOrders);
    public void writeData(List<PizzaOrderVO> pizzaOrders) throws Exception;
}
