package komis;

import java.util.List;

import komis.db.EntityBase;

public class Offer extends EntityBase {


        
        private int price;
        private Offer offer;
        
        public Offer getOffer() {
    		return offer;
    	}
    	public void setOffer(Offer offer) {
    		this.offer = offer;
    	} 
        
        
    	private List<Transaction> transactions;
    	
    	public List<Transaction> getTransactions() {
    		return transactions;
    	}
    	public void setTransactions(List<Transaction> transactions) {
    		this.transactions = transactions;
    	}
                

        public int getPrice() {
                return price;
        }

        public void setPrice(int price) {
                this.price = price;
        }

    	

                        
}