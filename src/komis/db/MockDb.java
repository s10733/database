package komis.db;

import java.util.ArrayList;
import java.util.List;



public class MockDb {

		private List<EntityBase> items;
		private int size;
		public MockDb() {
			this.items = new ArrayList<EntityBase>();
		}
		
		public List<EntityBase> getItems() {
			return items;
		}
		
		public void addToList(EntityBase obj)
		{
			size++;
			obj.setId(size);
			items.add(obj);
		}
		

}
