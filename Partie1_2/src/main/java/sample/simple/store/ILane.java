package sample.simple.store;

import sample.simple.extObj.Account;
import sample.simple.extObj.Article;

public interface ILane {

	public void addItemToPay(Article article);
	public void pay(Account account);
	
}
