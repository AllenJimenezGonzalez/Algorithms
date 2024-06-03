package ThreadsAndLocks;

import java.util.Date;
import java.util.concurrent.CompletableFuture;

public class TimeInAThread {
    public static void main(String[] args) {

        CompletableFuture<Object> future = CompletableFuture.supplyAsync(() -> {
            Date startTime = new Date();
            System.out.println("Started at: " + startTime);

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Finished at: " + new Date());
            System.out.println("Total time: " + (new Date().getTime() - startTime.getTime()) + "ms");
            return null;
        });

        CompletableFuture<Object> future1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("This is the second future");
            Date startTime = new Date();
            System.out.println("Started at: " + startTime);

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Finished at: " + new Date());
            System.out.println("Total time: " + (new Date().getTime() - startTime.getTime()) + "ms");
            return null;
        });
        
        future.thenCompose((result) -> {
            System.out.println("This is the result: " + result);
            return future1;
        });


        Thread t = new Thread(new AsyncPractice());
        t.start();
    }
}


class AsyncPractice implements Runnable {
    Date startTime = new Date();

    @Override
    public void run() {
        System.out.println("Started at: " + startTime);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Finished at: " + new Date());
        System.out.println("Total time: " + (new Date().getTime() - startTime.getTime()) + "ms");
    }

}
