public class TestTickets {
    public static void main(String[] args) {
        Tickets t=new Tickets();
        Thread t1=new Thread(t, "窗口1");
        Thread t2=new Thread(t, "窗口2");
        Thread t3=new Thread(t, "窗口3");
        Thread t4=new Thread(t, "窗口4");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }


}
