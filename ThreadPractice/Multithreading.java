package ThreadPractice;


public class Multithreading {
    
    int count=0;
    static int n;
  
  
    public void printEven() 
    {
      synchronized(this)
      {
        while(count<n)
        {
        if (count%2==1)
        {
          try {
            wait();
          } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
          }
        }
  
        System.out.println(Thread.currentThread().getName()+":"+count);
        notify();
        count++;
        }
      }
    }
    public void printOdd() 
    {
      synchronized(this)
      {
        while(count<n)
        {
        if (count%2==0)
        {
          try {
            wait();
          } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
          }
        }
  
        System.out.println(Thread.currentThread().getName()+":"+count);
        count++;
        notify();
        }
      }
    }
  
    public static void main(String[] args) throws  InterruptedException {
  
      n= 30;
  
      Multithreading app=new Multithreading();
      
      Runnable r=()->app.printOdd();
      
     new Thread(r,"Odd thread").start();
  
      r=()->app.printEven();
  
     new Thread(r,"Even Thread").start(); 
      
    }
  
  }
  
  
  
  
