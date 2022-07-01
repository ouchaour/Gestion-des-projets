package Persistance;

public interface DAOCRUD<u,j> {
	public void creer(u a);
	public u read(j a);
	public void update (u a);
	public void deleat(u a);
}
