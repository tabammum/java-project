package bankingsystem;

class CurrentAccount extends Account{

	CurrentAccount(String name , float balance){
		super(name , balance);
	}
	public void changeInterest(float interest){
		super.interest = interest;
	}
	public void addInterest(int year){
		for(int i = 1 ; i<=year ; i++){
			super.balance = super.balance +super.balance*(super.interest/100);
		}
	}
	public float deposite(int amount){
		super.balance = super.balance+amount;
		return balance;
	}
	public void withdraw(int amount){
		super.balance = super.balance - amount;
	}
}

