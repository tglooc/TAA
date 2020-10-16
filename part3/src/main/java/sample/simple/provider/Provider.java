package sample.simple.provider;

import org.springframework.stereotype.Component;

import sample.simple.extObj.Article;
import sample.simple.extObj.Operation;

@Component
public class Provider implements IProvider {

	public Provider() {
	}

	@Override
	public float getPrice(Article article) {
		return article.getPrice();
	}

	@Override
	public void order(Article article, int qty) {
		article.updateQty(Operation.addtion, qty);
		System.out.println(
				"article " + article.getName() + " : qty updated : " + qty + " new quantity : " + article.getQty());
	}

}
