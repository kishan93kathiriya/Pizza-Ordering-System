package com.challange.PizzaOrderingSystem.Services;

import com.challange.PizzaOrderingSystem.Model.PizzaOrderVO;
import com.challange.PizzaOrderingSystem.RestServices.FileServices;
import com.challange.PizzaOrderingSystem.RestServices.FileServicesImpl;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class TestPizzaSortingOrder {

    @Autowired
    private FileServices fileServices = new FileServicesImpl();
    private String filePath = "src/test/resources/sample_data_ordered.txt";

    @Test
    public void test() throws Exception {
        List<PizzaOrderVO> list = new ArrayList<PizzaOrderVO>();
        List<String> name = new ArrayList<String>();
        List<String> date = new ArrayList<String>();
        name = this.getName();
        date = this.getDate();
        list = fileServices.readDataAndSort(filePath);
        for (int i = 0; i < list.size(); i++) {
            Assert.assertEquals(name.get(i), list.get(i).getName());
            Assert.assertEquals(date.get(i), list.get(i).getDate().toString());

        }
    }

    private List<String> getName() {
        List<String> name = new ArrayList<String>();
        name.add("Meat");
        name.add("pizza");
        name.add("p1zza");
        name.add("Bread");
        name.add("Pizza");
        name.add("bread");
        name.add("bread");
        name.add("meatMeaT");
        name.add("VegVeg");
        return name;
    }

    private List<String> getDate() {
        List<String> date = new ArrayList<String>();
        date.add("Sat Sep 23 10:24:47 EDT 2017");
        date.add("Thu Oct 27 10:24:47 EDT 2016");
        date.add("Wed Oct 26 10:24:47 EDT 2016");
        date.add("Tue Oct 25 10:24:47 EDT 2016");
        date.add("Mon Oct 24 10:24:47 EDT 2016");
        date.add("Sun Oct 23 10:24:47 EDT 2016");
        date.add("Fri Sep 23 10:24:47 EDT 2016");
        date.add("Mon Sep 19 10:24:47 EDT 2016");
        date.add("Mon Sep 19 10:24:47 EDT 2016");
        return date;
    }
}
