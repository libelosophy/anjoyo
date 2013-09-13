package com.jh.thread.synchronize;

class AccountOperator implements Runnable {

	private Account account; 
	private double drawMoney;

	public AccountOperator(Account account, double drawMoney) {
		super();
		this.setAccount(account);
		this.setDrawMoney(drawMoney);
	}

	
	
	@Override
	public void run() {
	// 同步代码块  account 为
		
		double money = 0;
		synchronized (account) {
			
			if( getDrawMoney() < 0 && Math.abs(getDrawMoney()) > getAccount().getBalance()){ //取钱
				System.out.println(Thread.currentThread().getName() 
						+ " 取钱操作，余额不足！！！");
			}else {
				System.out.println(
						Thread.currentThread().getName()+ 
						"操作，从 账户" + getAccount().getName() 
						+ " 中 " + getDrawMoney() + " 元");
				money = getAccount().getBalance() + getDrawMoney();
				getAccount().setBalance(money);
			}

			System.out.println(Thread.currentThread().getName() 
						+ "，余额： " + getAccount().getBalance());
		}
		
	}



	public double getDrawMoney() {
		return drawMoney;
	}



	public void setDrawMoney(double drawMoney) {
		this.drawMoney = drawMoney;
	}



	public Account getAccount() {
		return account;
	}



	public void setAccount(Account account) {
		this.account = account;
	}
	

	
}