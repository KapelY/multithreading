package forkJoinPool;

public class RecursiveAction extends java.util.concurrent.RecursiveAction {
    int work;

    public RecursiveAction(int work) {
        this.work = work;
    }

    @Override
    protected void compute() {
        if (work > 100) {
            System.out.println("Starting splitting tasks!!!" + work);
            RecursiveAction recursiveAction1 = new RecursiveAction(work /2);
            RecursiveAction recursiveAction2 = new RecursiveAction(work /2);

            recursiveAction1.fork();
            recursiveAction2.fork();
        } else {
            System.out.println(" ok " + work);
        }
    }
}
