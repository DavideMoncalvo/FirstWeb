package dm.demos.data;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import fr.demos.formation.Climatisation;

public class FileClimatisationDAO implements ClimatisationDAO {

	@Override
	public void sauve(Climatisation cl) throws Exception {
		List<Climatisation> liste = null;
		try{
			liste = this.rechercheTout();
		
		}catch(Exception exc){
			// si la recherche plante c'est ne pas forcement un pb : le ficheir n'existe pas encore
			System.out.println(exc.getMessage());
			// on cree la list car on l'a pas recupere depuis le fichier
			liste = new ArrayList<>();
		}
	    liste.add(cl);

		try (ObjectOutputStream oos = new ObjectOutputStream(
				new BufferedOutputStream(new FileOutputStream("climatisation")));) {
			oos.writeObject(liste);
			oos.flush();
		}
	}

	@Override
	public List<Climatisation> rechercheTout() throws Exception {
		ArrayList<Climatisation> listClim = null;
		
		try (ObjectInputStream ois = new ObjectInputStream(
				new BufferedInputStream(new FileInputStream("climatisation")));) {
				listClim = (ArrayList<Climatisation>) ois.readObject();
		}
		return listClim;
		
	}

	@Override
	public List<Climatisation> recherche(String critere) throws Exception {

		return null;
	}

	@Override
	public int nombre(String critere) {
		List<Climatisation> liste = null;
		int nb = 0;
		try{
			liste = this.rechercheTout();
			nb = liste.size();
		
		}catch(Exception exc){
			// si la recherche plante c'est ne pas forcement un pb : le ficheir n'existe pas encore
			System.out.println(exc.getMessage());
			
		}
		return nb;
	}

}
