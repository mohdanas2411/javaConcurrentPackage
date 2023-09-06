package concurrentApi.completableFuture;

import java.util.Random;
import java.util.concurrent.Callable;

public class Tasks {

    public Product getProduct() {
        return new Product();
    }

    public Product enrichProduct(Product product) {
        product.setProductId(new Random().nextInt(100));
        product.setProductName("peoduct_" + product.getProductId());
        return product;
    }

    public Product performPayment(Product product) {
        product.setPayment(true);
       // int i = 1/0;
        return product;
    }

    public void sendProduct(Product product) {
        System.out.println("Product id : " + product.getProductId());
        System.out.println("Product Name : " + product.getProductName());
        System.out.println("Product payment Status : " + product.isPayment());
        System.out.println();
    }
}
