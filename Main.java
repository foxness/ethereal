import java.util.*;

class Main
{
    public static void main(String[] args) throws InterruptedException
    {
        System.out.println("Hello world!");

        List<Worker> workers = new ArrayList<Worker>();

        for (int i = 0; i < 5; ++i)
        {
            Worker worker = new Worker();
            worker.start();
            workers.add(worker);
        }

        WorkBalancer balancer = new WorkBalancer(workers);
        
        for (int i = 0; i < 10; ++i)
        {
            balancer.execute(() -> {
                try
                {
                    DoWork();
                }
                catch (Exception e)
                {
                    //
                }
            });
        }
    }

    static void DoWork() throws InterruptedException
    {
        Thread.sleep(2000);
        System.out.println("I did work for 2 seconds");
    }
}