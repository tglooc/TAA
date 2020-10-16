package sample.simple.bank;

import org.springframework.stereotype.Component;

import sample.simple.extObj.Account;
import sample.simple.extObj.Operation;

@Component
public class Bank implements IBank {

	@Override
	public void transfert(Account a1, Account a2, int sum) {
		if (a1.getAmount() >= sum) {
			a1.updateAmount(Operation.substraction, sum);
			a2.updateAmount(Operation.addtion, sum);
		}
		System.out.println("transfert effectué de " + a1.getUserId() + " a " + a2.getUserId() + " de " + sum + "eu");
	}
}
