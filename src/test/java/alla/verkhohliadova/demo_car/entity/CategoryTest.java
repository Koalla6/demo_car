package alla.verkhohliadova.demo_car.entity;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CategoryTest {

    @Test
    public void getAllNames(){
        Category category1 = new Category();
        Category category2 = new Category();


        category1.setName("A КЛАС — MINI CARS");
        category2.setName("B КЛАС — SMALL CARS");

        List<Category> expected = new ArrayList<>();
        expected.add(category1);

        List<Category> actual = new ArrayList<>();
        //actual.add(category1);
        actual.add(category2);

        Assert.assertEquals(expected,actual);
    }
}