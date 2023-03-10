package Task06;

import java.util.Vector;


/**
 * The class Command queue implements queue
 */
public class CommandQueue implements Queue{
    private Vector<Command> tasks;

    private boolean waiting;

    private boolean shutdown;
    
    /**
     * Shutdown
     */
    public void shutdown() {

        shutdown = true;
    }

    /**
     * Command queue
     * @return public
     */
    public CommandQueue() {

        tasks = new Vector<Command>();
        waiting = false;
        new Thread(new Worker()).start();
    }

    @Override
    /**
     * Put
     * @param r  the r
     */
    public void put(Command r) {

        tasks.add(r);
        if (waiting) {
            synchronized (this) {
                notifyAll();
            }
        }
    }

    @Override
    /**
     * Take
     * @return Command
     */
    public Command take() {

        if (tasks.isEmpty()) {
            synchronized (this) {
                waiting = true;
                try {
                    wait();
                } catch (InterruptedException ie) {
                    waiting = false;
                }
            }
        }
        return (Command)tasks.remove(0);
    }

    private class Worker implements Runnable {

        /**
         * Run
         */
        public void run() {

            while (!shutdown) {
                Command r = take();
                r.execute();
            }
        }
    }
}
