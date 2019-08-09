package com.challange.PizzaOrderingSystem.Controller;

import com.challange.PizzaOrderingSystem.RestServices.SortingServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PizzaOrderController {
    private SortingServices sortingServices;

    @Autowired
    public PizzaOrderController(SortingServices sortingServices){
        this.sortingServices = sortingServices;
    }

    @RequestMapping("/sortPizzaOrders")
    public String sortingPizzaOrders(){
        try {
            sortingServices.sortPizzaOrders();
        } catch (Exception ex) {
            return "<html><body><div style=\"color:red; text-align: center; font-family: Sans-serif; font-size: 40px;\"><h1>"+ex.getMessage().toString()+"</h1></div></body></html>";
        }
        return "<html>"+
                "<body>"+
                "<div style=\"color:green; text-align: center;font-family: Sans-serif; font-size: 50px;\""+
                "<h1>"+
                "Hurrraayyyy!! Your Data has been sorted. </br>Go to the location below to check the output :)"+
                "</h1>"+
                "</div></br></br>"+
                "<p><b>"+
                "<h3 style=\"color:blue; text-align: center; font-size: 40px; font-family: Sans-serif;\">~/src/main/Resources/SortedPizzaOrderOutput.txt</h3>"+
                "</b></p>"+
                "</body>"+
                "</html>";
    }
}
