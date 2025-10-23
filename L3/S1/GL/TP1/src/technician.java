
public class technician extends personne{

	private int matricule;
	private specialite specialte;
	public technician(int matricule, specialite specialte, String nom , String prenom , String email , String login , String password) {
		super(nom , prenom , email , login , password);
		this.matricule = matricule;
		this.specialte = specialte;
	}
	
	
	public technician() {
		
	}

	public int getMatricule() {
		return matricule;
	}
	public void setMatricule(int matricule) {
		this.matricule = matricule;
	}
	public specialite getSpecialte() {
		return specialte;
	}
	public void setSpecialte(specialite specialte) {
		this.specialte = specialte;
	}


	@Override
	public String toString() {
		return super.toString() + " [matricule=" + matricule + ", specialte=" + specialte + "]";
	}
	
	void afficher()
	{
	  System.out.println(this.toString());
	}
	
	
	
	
}
