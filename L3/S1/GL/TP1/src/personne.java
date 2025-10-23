
public class personne {
	
	private String nom;
	private String prenom;
	private String email;
	private String login;
	private String password;
	private specialite specialite;
	
	
	public personne(String nom, String prenom, String email, String login, String password) {
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.login = login;
		this.password = password;
	}
	
	
	
	public personne() {
		
	}


	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String toString() {
		return "[nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", login=" + login + ", password="
				+ password + "]";
	}
	
	void afficher()
	{
	  System.out.println(this.toString());
	}
	
	boolean sauthentifier1(String login, String password)
	{
		return this.login.equals(login) && this.password.equals(password);
	}
	
	boolean sauthentifier2(String login, String password) {
	    int i = 0;
	    while (i < 3) {
	        if (this.login.equals(login) && this.password.equals(password)) {
	            return true; 
	        } else {
	            i++;
	            System.out.println("wrong credentials!");
	        }
	    }
	    return false; 
	}

	
}

	
