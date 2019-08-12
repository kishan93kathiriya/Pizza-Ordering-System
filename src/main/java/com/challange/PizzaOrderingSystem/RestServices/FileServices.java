package com.challange.PizzaOrderingSystem.RestServices;

import com.challange.PizzaOrderingSystem.Model.PizzaOrderVO;

import java.util.List;

public interface FileServices {

    public List<PizzaOrderVO> readDataAndSort(String filePath) throws Exception;
    public void writeData(List<PizzaOrderVO> pizzaOrders) throws Exception;
}
