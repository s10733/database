package komis;

import java.util.List;

import komis.db.EntityBase;

public class Transaction extends EntityBase {

	
	private String date;
	private double price;
	
	//relacja Transakcja - klient
	private Client client;
	
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	
	//relaca Transakcja - sprzedawca
	
	private Seller seller;
	
	public Seller getSeller() {
		return seller;
	}
	public void setSeller(Seller seller) {
		this.seller = seller;
	}
	
	// relacja Transakcja - oferta
	
	private List<Offer> Offers;
	
	
	public List<Offer> getOffers() {
		return Offers;
	}
	public void setOffers(List<Offer> offers) {
		Offers = offers;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
}
