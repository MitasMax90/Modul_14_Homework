public class Main {
    public static void main(String[] args) {
        ATM atm = new ATM(1000);

        // создаём клиентов, каждый из которых будет отдельным потоком
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                atm.withDraw("Игорь", 300);
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
//                try {
//                    thread1.join();                // В потоке 2 ждём, пока выполнится 1-й поток
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                atm.withDraw("Василий", 500);
            }
        });

        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
//                try {
//                    thread2.join();                // В потоке 3 ждём, пока выполнится 2-й поток
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                atm.withDraw("Сергей", 400);
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();
    }
}