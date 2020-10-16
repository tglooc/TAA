package sample.simple.provider;

import sample.simple.extObj.Article;

public interface IProvider {

	public float getPrice(Article article);
	public void order(Article article, int qty);
	
}
