package com.challange.PizzaOrderingSystem.RestServices;

import com.challange.PizzaOrderingSystem.Model.PizzaOrderVO;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
public class FileServicesImpl implements FileServices{

    @Override
    public List<PizzaOrderVO> readData(String filePath) throws Exception {
        List<PizzaOrderVO> pizzaOrders = new ArrayList<PizzaOrderVO>();
        String input="";

        try {
            FileInputStream fileInput = new FileInputStream(filePath);
            DataInputStream dataInput = new DataInputStream(fileInput);
            BufferedReader br = new BufferedReader(new InputStreamReader(dataInput));
            br.readLine();
            while( (input = br.readLine()) != null && input.trim().length() !=0){
                String[] fileData = input.split("\\s+");
                PizzaOrderVO order = new PizzaOrderVO(fileData[0], new Date(Long.parseLong(fileData[1]) * 1000));
                pizzaOrders.add(order);
            }
        } catch (FileNotFoundException ex){
            throw ex;
        } catch (IOException ex) {
            throw ex;
        }
        return pizzaOrders;
    }

    @Override
    public void writeData(List<PizzaOrderVO> pizzaOrders) throws Exception {
        PrintWriter printWriter;
        try{
            printWriter = new PrintWriter("src/main/resources/SortedPizzaOrderOutput.txt", "UTF-8");
            String formatter = "%-30.30s  %-30.30s%n";
            StringBuffer data= new StringBuffer();
            data.append(String.format(formatter, "Order", "Time (in EDT)"));
            data.append("-------------------------------------------------------------\n\n");
            for(PizzaOrderVO pizzaOrder: pizzaOrders){
                data.append(String.format(formatter, pizzaOrder.getName(), pizzaOrder.getDate().toString()));
            }
            printWriter.println(data.toString());
        } catch (FileNotFoundException ex) {
            throw ex;
        }
        printWriter.close();
    }

    @Override
    public List<PizzaOrderVO> sortData(List<PizzaOrderVO> pizzaOrders){
        Collections.sort(pizzaOrders);
        return pizzaOrders;
    }
}
