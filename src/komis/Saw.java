package komis;

import java.util.List;

public class Saw {
		
		//relacja Kliet-Obejrzane
		private List<Client> clients;
		
		//relacja Klient-oferta
		
		private List<Offer> offers;

		public List<Client> getClients() {
			return clients;
		}

		public void setClients(List<Client> clients) {
			this.clients = clients;
		}

		public List<Offer> getOfferts() {
			return offers;
		}

		public void setOfferts(List<Offer> offers) {
			this.offers = offers;
		}
}
