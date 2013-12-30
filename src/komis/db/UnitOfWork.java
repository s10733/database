package komis.db;



public interface UnitOfWork {
	
	public void markNew(EntityBase ent, UnitOfWorkDao dao);
	public void markDelete(EntityBase ent, UnitOfWorkDao dao);
	public void markUpdate(EntityBase ent, UnitOfWorkDao dao);
	public void commit();
	public void close();

}
