package com.challange.PizzaOrderingSystem.RestServices;

import com.challange.PizzaOrderingSystem.Model.PizzaOrderVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SortingServicesImpl implements SortingServices{

    private FileServices fileServices;

    @Value("src/main/resources/sample_data_ordered.txt")
    private String filePath;

    @Autowired
    public SortingServicesImpl(FileServices fileServices){
        this.fileServices = fileServices;
    }

    @Override
    public void sortPizzaOrders() throws Exception {
        List<PizzaOrderVO> pizzaOrders = fileServices.readData(filePath);
        pizzaOrders = fileServices.sortData(pizzaOrders);
        fileServices.writeData(pizzaOrders);
    }
}
