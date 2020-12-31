package messagePackTest;


class Data2 {
    volatile int number;

    //将number的值改成10
    public void add_1() {
        number++;
    }

}

public class test {

    public static void main(String[] args) {
        Data2 data2 = new Data2();

        //10个线程，每个线程调用1000个加1操作
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    data2.add_1();
                }
            }).start();
        }

        //让 main 线程等待5秒，等上面10000个线程执行完
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //输入 number 的值
        System.out.println(data2.number);

    }
}

