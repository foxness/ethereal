import java.util.*;

class WorkBalancer
{
    private List<Worker> workers;

    public WorkBalancer(List<Worker> workers_)
    {
        workers = workers_;
    }

    void execute(Runnable task) throws InterruptedException
    {
        Worker minWorker = workers.stream().min((w1, w2) -> Integer.compare(w1.getWorkCount(), w2.getWorkCount())).get();
        minWorker.execute(task);
    }
}