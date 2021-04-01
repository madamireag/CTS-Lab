package ro.ase.acs.main;

import ro.ase.acs.builder.Product;
import ro.ase.acs.builder.ProductBuilderV2;

import java.util.Date;

public class Main {
    public static void main(String[] args) {

//        Product product = new Product("milk",10,12345,23,null,0,false,true,true);
//        Product product2 = new Product("chocolate",7);
//        product2.setQuantity(10);
//        product2.setBarcode(123123);
//        //...
//        product2.setExpireDate(new Date());

        Product product3 = new Product.ProductBuilder()
                .addName("milk")
                .addBarCode(12345)
                .addQuantity(23)
                .addIsVegetarianFriendly(true)
                .addIsGlutenFree(true)
                .build();

        ProductBuilderV2 productBuilderV2 = new ProductBuilderV2();
        productBuilderV2.addName("chocolate");
        productBuilderV2.addPrice(7);
        productBuilderV2.addQuantity(10);
        productBuilderV2.addBarCode(123123);
        Product product4 = productBuilderV2.build();


    }



}
