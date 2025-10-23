import java.util.Date;

public class chef_atelier extends technician{

	private int NbExperience;
	private Date DateExperience;
	private Date DatePromotion;
	private status status;
	private specialite specialte;
	
	
	public chef_atelier(int nbExperience, Date dateExperience, Date datePromotion, status status,int matricule, specialite specialte, String nom, String prenom, String email, String login, String password) {
		super(matricule, specialte, nom, prenom, email, login, password);
		NbExperience = nbExperience;
		DateExperience = dateExperience;
		DatePromotion = datePromotion;
		this.status = status;
	}
	
	
	public chef_atelier() {

	}

	
	public int getNbExperience() {
		return NbExperience;
	}
	public void setNbExperience(int nbExperience) {
		NbExperience = nbExperience;
	}
	public Date getDateExperience() {
		return DateExperience;
	}
	public void setDateExperience(Date dateExperience) {
		DateExperience = dateExperience;
	}
	public Date getDatePromotion() {
		return DatePromotion;
	}
	public void setDatePromotion(Date datePromotion) {
		DatePromotion = datePromotion;
	}
	public status getStatus() {
		return status;
	}
	public void setStatus(status status) {
		this.status = status;
	}


	
	public String toString() {
		return "Chef d’Atelier {" +  super.toString() + ", NbExpérience: " + NbExperience + ", DateExpérience: " + DateExperience +  ", DatePromotion: " + DatePromotion +  ", Statut: " + status +"}";
	}
	
	public void afficher() {
		System.out.println(this.toString());
	}
	
	public int miseajourexp (Date dateexp) {
		Date curr = new Date();
		long diff = curr.getTime() - dateexp.getTime();	
		int years = (int)(diff / (1000L * 60 * 60 * 24 * 365));
		this.NbExperience = years;
		return years;
	}
}

	
