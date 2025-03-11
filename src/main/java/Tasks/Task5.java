package Tasks;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

public class Task5 {
     public interface Task {
         /**
          * Запускает задачу
          */
         void start();

         /**
          * Останавливает задачу
          */
         void stop();
     }

     public static class TaskProcessing implements Task {
         public TaskProcessing() {
             this.packageQueue = new LinkedList<>();
             this.isStarting = false;
         }

         @Override
         public void start() {
             isStarting = true;
             System.out.println("Чтение данных ...");

             new Thread(() -> {
                 while (isStarting) {
                     synchronized (packageQueue) {
                         while (packageQueue.isEmpty() && isStarting) {
                             try {
                                 packageQueue.wait();
                             } catch (InterruptedException e) {
                                 throw new RuntimeException(e);
                             }
                         }
                         var taskPackage = packageQueue.poll();
                         if(taskPackage != null) {
                             executeDelay(1);
                             System.out.println("Обработка данных: " + taskPackage);
                         }
                     }
                 }
                 System.out.println("Обработка данных остановлена.");
             }).start();
         }

         @Override
         public void stop() {
             isStarting = false;
             synchronized (packageQueue) {
                 packageQueue.notify();
             }
         }

         public synchronized void addPackage(String taskPackage) {
             synchronized (packageQueue) {
                 packageQueue.add(taskPackage);
                 packageQueue.notify();
             }
         }

         private final Queue<String> packageQueue;
         private volatile boolean isStarting;
     }

    public static void executeDelay(int timeInSeconds) {
        try {
            TimeUnit.SECONDS.sleep(timeInSeconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
