package WORK4;

public class MachineTest {
    public static void main(String[] args)
    {
        Bus bus = new Bus();
        bus.setPrice(15000);
        bus.start();
        bus.stop();
        bus.Run();
        bus.start();
        bus.Run();
        bus.stop();
        System.out.println(bus);
    }
}

interface Machine
{
    void setPrice(double p);

}

interface Moveable
{
    void start();
    void stop();
}

interface Vehicle extends Machine, Moveable
{
    void Run();
}

class Bus implements Vehicle
{
    private double price;

    enum Status
    {
        START, RUN, STOP
    }

    private Status status;

    public Bus()
    {
        price = 0;
        status = Status.STOP;
    }

    @Override
    public void setPrice(double p)
    {
        price = p;
    }

    @Override
    public void start()
    {
        if(status == Status.STOP) {
            status = Status.START;
            System.out.println("Starting engine...");
        }
        else
        {
            System.out.println("Bus is " + status + ", cannot start now!");
        }

    }

    @Override
    public void stop()
    {
        if(status != Status.STOP) {
            status = Status.STOP;
            System.out.println("Shutting down engine...");
        }
        else
        {
            System.out.println("Bus is " + status + ", cannot stop now!");
        }
    }

    @Override
    public void Run()
    {
        if(status == Status.START) {
            status = Status.RUN;
            System.out.println("Running on road...");
        }
        else
        {
            System.out.println("Bus is " + status + ", cannot run now!");
        }
    }

    @Override
    public String toString()
    {
        return "Bus is worth "+ price + ", status = " + status;
    }
}
