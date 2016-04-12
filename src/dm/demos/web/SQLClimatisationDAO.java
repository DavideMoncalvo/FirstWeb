package dm.demos.web;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.sql.DataSource;
import javax.naming.InitialContext;

import dm.demos.data.ClimatisationDAO;
import fr.demos.formation.Climatisation;

public class SQLClimatisationDAO implements ClimatisationDAO {

	private DataSource ds;

	public SQLClimatisationDAO() throws Exception {
		// recherche dans l'annuaire du pool connexions (utilisation de la librerie INDI)
		Context context = new InitialContext();
		ds = (DataSource) context.lookup("jdbc/appliclim");
	}

	@Override
	public void sauve(Climatisation cl) throws Exception {
		// on demand une connecxion au pool
		Connection cx = (Connection) ds.getConnection();
		// on va pouvoir préparer notre requete SQL
		PreparedStatement psmt = cx.prepareStatement("insert into climatisation values (?,?,?,?,?)");
		psmt.setString(1, cl.getApp());
		psmt.setDouble(2, cl.getTemperature());
		psmt.setDouble(3, cl.getPression());
		psmt.setInt(4, cl.getHumidite());
		psmt.setLong(5, cl.getDatation());
		psmt.executeUpdate();
		cx.close();

	}

	@Override
	public List<Climatisation> rechercheTout() throws Exception {
		Connection cx = (Connection) ds.getConnection();
		PreparedStatement psmt = cx.prepareStatement("select * from climatisation");
		ResultSet rs = psmt.executeQuery();
		ArrayList<Climatisation> liste = new ArrayList<>();
		while(rs.next()) {
			String app = rs.getString(1);
			double temperature = rs.getDouble(2);
			double  pression = rs.getDouble(3);
			int humidite = rs.getInt(4);
			long datation = rs.getLong(5);
			Climatisation cl = new Climatisation(app, temperature, pression, humidite);
			liste.add(cl);
		}
		return liste;
	}

	@Override
	public List<Climatisation> recherche(String critere) throws Exception {

		return null;
	}

	@Override
	public int nombre(String critere) {
		int nb = 0;
        try{
        	//peu performant : en sql on peut demander directement le nb d,element
        	List<Climatisation> liste = this.rechercheTout();
        	nb = liste.size();
        }catch(Exception exc){}
        return nb;
	}

}
