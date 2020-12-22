import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class GestorBD {
	private Connection conexion = null;
	private Statement stm = null;
	private ResultSet robResultSet;
	private Integer n;
	private String nombre, descripcion, marca, funcion, peso;
	
	
	public ArrayList<rob> leerrob() {
		ArrayList<rob> rob = new ArrayList<rob>();
		rob robHallada;
		try {
			ConectaBD ConectaBD = new ConectaBD();
			conexion = ConectaBD.getConexion();
			stm = conexion.createStatement();
			robResultSet = stm.executeQuery("select * from consolidado");
			if (!robResultSet.next()) {
				System.out.println("No se encontraron registros");
				conexion.close();
				return null;
				} else {
					do {
						n = robResultSet.getInt("n");
						nombre = robResultSet.getString("nombre");
						descripcion = robResultSet.getString("descripcion");
						marca = robResultSet.getString("marca");
						funcion = robResultSet.getString("funcion");
						peso = robResultSet.getString("peso");
						robHallada = new rob(n, nombre, descripcion, marca, funcion, peso);
						rob.add(robHallada);
						} while (robResultSet.next());
					conexion.close();
					return rob;
					}
			} catch (Exception e) {
				System.out.println("Error en la base de datos.");
				e.printStackTrace();
				return null;
				}
	}
	


}