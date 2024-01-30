public class Deadlock {

  static final String res1 = "Resource1";
  static final String res2 = "Resource2";

  public static void main(String[] args) {
    Runnable runnable =
      (
        () -> {
          synchronized (res1) {
            System.out.println(
              Thread.currentThread().getName() + " accessing " + res1
            );
            try {
              Thread.sleep(2000);
            } catch (InterruptedException e) {}

            synchronized (res2) {
              System.out.println(
                Thread.currentThread().getName() + " accessing " + res2
              );
            }
          }
        }
      );

    

    Runnable runnable2 =
    (
      () -> {
        synchronized (res2) {
          System.out.println(
            Thread.currentThread().getName() + " accessing " + res2
          );
          try {
            Thread.sleep(2000);
          } catch (InterruptedException e) {}

          synchronized (res1) {
            System.out.println(
              Thread.currentThread().getName() + " accessing " + res1
            );
          }
        }
      }
    );


  
    new Thread(runnable, "Thread1").start();
    new Thread(runnable2, "Thread2").start();
  }
}
