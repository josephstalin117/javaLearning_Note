class Bank implements Runnable {
	private int money = 0;
	Thread zhang, cheng;

	Bank() {
		// 创建的bank对象是zhang的目标对象,Bank类必须实现Runnable接口。
		zhang = new Thread(this);
		zhang.setName("会计");
		cheng = new Thread(this); // cheng 和zhang是同一目标对象。
		cheng.setName("出纳");
	}

	public void setMoney(int mount) {
		money = mount;
	}

	public void run() // 接口中的方法。
	{
		while (true) {			
			if (Thread.currentThread() == zhang) {
				money = money - 10;
				if (money <= 100){
					System.out.println("会计线程将退出");
				}
				System.out.printf("我是%s,现在有%d元\n", zhang.getName(), money);
				if (money <= 100){
					return; // 如果money少于50,zhang的run方法结束。
				}
			} else if (Thread.currentThread() == cheng) {
				money = money + 10;
				if (money >= 200){
					System.out.println("出纳线程将退出");
				}
				System.out.printf("我是%s,现在有%d元\n", cheng.getName(), money);
				if (money >= 200){
					return; // 如果money少于0,cheng的run方法结束。
				}
			}
			try {
				Thread.sleep((int) (Math.random() * 100) + 100);
			} catch (InterruptedException e) {
			}
		}
	}
}

public class TestRunnable {
	public static void main(String args[]) {
		Bank bank = new Bank();
		bank.setMoney(110); // 线程的目标对象设置被线程共享的money。
		bank.zhang.start();
		bank.cheng.start();
	}
}
