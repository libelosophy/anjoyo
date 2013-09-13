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
	// ͬ�������  account Ϊ
		
		double money = 0;
		synchronized (account) {
			
			if( getDrawMoney() < 0 && Math.abs(getDrawMoney()) > getAccount().getBalance()){ //ȡǮ
				System.out.println(Thread.currentThread().getName() 
						+ " ȡǮ���������㣡����");
			}else {
				System.out.println(
						Thread.currentThread().getName()+ 
						"�������� �˻�" + getAccount().getName() 
						+ " �� " + getDrawMoney() + " Ԫ");
				money = getAccount().getBalance() + getDrawMoney();
				getAccount().setBalance(money);
			}

			System.out.println(Thread.currentThread().getName() 
						+ "���� " + getAccount().getBalance());
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