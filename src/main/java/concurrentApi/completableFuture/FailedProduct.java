package concurrentApi.completableFuture;

public class FailedProduct extends Product {

    public FailedProduct() {
        System.out.println("Exception occur");
    }
}
