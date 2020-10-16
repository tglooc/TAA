package sample.simple.store;

import sample.simple.extObj.Account;
import sample.simple.extObj.Article;

public interface IFastLane {

	public void oneShotOrder(Article a, int qty, Account account);

}
