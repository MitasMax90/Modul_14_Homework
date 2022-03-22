public class ATM {

    // реализуем переменную количество денег
    private int amountOfMoney;
    private final Object lock = new Object(); // Данные объекты д.б. неизменяемыми, так что помечаем как final

    // создадим конструктор
    public ATM(int amountOfMoney) {
        this.amountOfMoney = amountOfMoney;
    }

    // реализуем метод, который в кач-ве параметра принимает имя чел-ка,
    // выводящего деньги и их количество
    public void withDraw(String name, int amountOfMoney) { // 1. помечаем withDraw как synchronized без блока synch. в теле метода
        synchronized (lock) {                              // 2. оборачиваем тело метода в synchronized по объекту синхронизации lock
            System.out.println(name + " подошёл к банкомату");
            try {
                Thread.sleep(5000);          // приостанавливаем метод на 5 сек
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (amountOfMoney <= this.amountOfMoney) {
                this.amountOfMoney -= amountOfMoney;
                System.out.println(name + " снял со счёта " + amountOfMoney);
                System.out.println("Осталось: " + this.amountOfMoney);
            } else {
                System.out.println("В банкомате недостаточно денег для " + name);
            }
        }
    }
}
