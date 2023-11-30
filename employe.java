import java.util.ArrayList;
public abstract class Employe {
	protected String nom,prenom;
	protected int age , date ;
	public Employe(String nom,String prenom, int age , int date ) {
		this.nom=nom;
		this.prenom=prenom;
		this.age=age;
		this.date=date;
	}
	protected abstract double calaculSalaire();
	protected String getNom() {
		return "l'employe"+prenom+" "+nom;
	}
}
public abstract class Employeca extends Employe{
	public double ca;
	public Employeca(String nom,String prenom,int age,int date ,double ca) {
	super(nom,prenom,age,date);
	this.ca=ca;
	
	}
@Override
public abstract double calculSalaire();
}

public class Vendeur extends Employeca{

	public Vendeur(String nom,String prenom,int age,int date ,double ca) {
		super(nom,prenom,age,date,ca);
	}
	@Override
	public double calculSalaire() {
		return 0.2*super.ca+400;
	}
	

}
public class Representant extends Employeca{

	public Representant(String nom,String prenom,int age,int date ,double ca) {
		super(nom,prenom,age,date,ca);
	}
	@Override
	public double calculSalaire() {
		return 0.2*super.ca+800;
	}
	

}


public class Interface {
	final double risk =200;
}



public class Technicien extends Employe{
	public double nb;
	public Technicien(String nom,String prenom,int age,int date ,double nb) {
		super(nom,prenom,age,date);
		this.nb=nb;
	}
@Override
public double calculSalaire() {
	return nb*5;
}

}


public class TechnARisque extends Technicien{

	public TechnARisque(String nom,String prenom,int age,int date ,double nb) {
		super(nom,prenom,age,date,nb);
	
	}
@Override
public double calculSalaire() {
	return super.calculSalaire()+risk;
}

}
public class Manutentionnaire extends Employe{
	public double nbr;

	public Manutentionnaire(String nom,String prenom,int age,int date ,double nbr) {
		super(nom,prenom,age,date);
		this.nbr=nbr;
	}
	@Override
	public double calculSalaire() {
		return nbr*65;
	}

}
public class ManutARisque extends Manutentionnaire{

	public ManutARisque(String nom,String prenom,int age,int date ,double nbr) {
		super(nom,prenom,age,date,nbr);
		
	}
	@Override
	public double calculSalaire() {
		return super.calculSalaire()+risk;
	}
}
public class Personnel {
	private ArrayList<employe> personne = new ArrayList<>();
public void ajouterEmploye(employe employee) {
	personne.add(employee);
}
public void afficherSalaires(){
	for(Employe employee : personne) {
		System.out.println(employee.getNom()+" gagne "+employee.calculSalaire()+" dinars");
	}
}
public double salaireMoyen() {
	double s=0;
	for(Employe employee :personne) {
		s=s+employee.calculSalaire();
	}
	return s/(personne.size());
}
}
class Salaires {
    public static void main(String[] args) {
        Personnel p = new Personnel();
        p.ajouterEmploye(new Vendeur("Ali", "Sassi", 45, "1995", 30000));
        p.ajouterEmploye(new Representant("Sami", "Soussi", 25, "2001", 20000));
        p.ajouterEmploye(new Technicien("Rami", "Bouaziz", 28, "1998", 1000));
        p.ajouterEmploye(new Manutentionnaire("Jacem", "Zrig", 32, "1998", 45));
        p.ajouterEmploye(new TechnARisque("Jalel", "Fetwi", 28, "2000", 1000));
        p.ajouterEmploye(new ManutARisque("Amir", "Ammar", 30, "2001", 45));
 
        p.afficherSalaires();
        System.out.println("Le salaire moyen est de " + p.salaireMoyen() + " dinars.");
    }
}
