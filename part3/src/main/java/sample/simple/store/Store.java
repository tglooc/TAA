package sample.simple.store;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sample.simple.bank.IBank;
import sample.simple.extObj.Account;
import sample.simple.extObj.Article;
import sample.simple.extObj.Operation;
import sample.simple.provider.IProvider;

@Component
public class Store implements IFastLane, ILane, IJustHaveALook {

	@Autowired
	IBank bank;
	@Autowired
	IProvider provider;

	Account account;

	List<Article> cart;

	public Store() {
		cart = new ArrayList<Article>();
		account = new Account(0, "0");
	}

	public Store(IBank bank, IProvider provider, Account account) {
		this.bank = bank;
		this.provider = provider;
		this.account = account;
		cart = new ArrayList<Article>();
	}

	@Override
	public float getPrice(Article article) {
		return article.getPrice();
	}

	@Override
	public boolean isAvailable(Article article) {
		return (article.getQty() != 0);
	}

	@Override
	public void addItemToPay(Article article) {
		if (isAvailable(article)) {
			cart.add(article);
			System.out.println("produit " + article.getName() + " ajoute avec succes au panier");
		} else
			System.out.println("article " + article.getName() + " indisponible");
	}

	@Override
	public void pay(Account account) {
		int total = 0;
		System.out.println("panier : ");
		for (Article a : cart) {
			total += a.getPrice();
			System.out.println("\tarticle " + a.getName());
		}
		if (account.getAmount() >= total) {
			for (Article a : cart) {
				a.updateQty(Operation.substraction, 1);
				if (a.getQty() == 0)
					provider.order(a, 10);
			}
			bank.transfert(account, this.account, total);
			cart.clear();
			System.out.println("transaction finie, facture : " + total);
		} else
			System.out.println("fond indisponible");
	}

	@Override
	public void oneShotOrder(Article a, int qty, Account account) {
		System.out.println("os order");
		cart.clear();
		for (int i = 0; i < qty; i++) {
			cart.add(a);
		}
		pay(account);
	}

}
