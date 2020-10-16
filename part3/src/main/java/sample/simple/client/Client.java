package sample.simple.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sample.simple.bank.Bank;
import sample.simple.extObj.Account;
import sample.simple.extObj.Article;
import sample.simple.provider.Provider;
import sample.simple.store.IFastLane;
import sample.simple.store.IJustHaveALook;
import sample.simple.store.ILane;
import sample.simple.store.Store;

@Component
public class Client implements IRun {

	@Autowired
	IJustHaveALook haveALook;
	@Autowired
	IFastLane fastLane;
	@Autowired
	ILane lane;

	private String nom;

	private Account account;

	public Client() {
		this.account = new Account(0, "0");
		nom = "";
	}

	public Client(Account account) {
		this.account = account;
		nom = "";
	}

	public Client(String nom) {
		this.nom = nom;
	}

	private Account getAccount() {
		return this.account;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void run() {
		System.out.println("ca tourne\n");

		Article a1 = new Article(1, "kalashnikov", 3600, 4);
		Article a2 = new Article(2, "m16", 4000, 7);

		Client c1 = new Client(new Account(8000, "c1"));
		Client c2 = new Client(new Account(21000, "c2"));

		Bank b1 = new Bank();

		Provider p1 = new Provider();

		Store s1 = new Store(b1, p1, new Account(100000, "s1"));

		s1.addItemToPay(a1);

		s1.pay(c1.getAccount());

	}
}
