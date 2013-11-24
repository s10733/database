package komis.db;

import java.util.List;

public interface Dao<E extends EntityBase> {

	public void save(E object);
	public void delete(E object);
	public void update(E object);
	public List<E> getAll();
	public E get(int id);
}
