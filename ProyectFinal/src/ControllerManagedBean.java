import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean (name = "ControllerManagedBean")
@SessionScoped

public class ControllerManagedBean {
	private Integer n;
	private String nombre;
	private String descripcion;
	private String marca;
	private String funcion;
	private String peso;
	private GestorBD GestorBD;
	private static ArrayList<rob> robList;

	public ControllerManagedBean() {
		GestorBD = new GestorBD();
		robList = GestorBD.leerrob();
	}

	public Integer getN() {
		return n;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public String getMarca() {
		return marca;
	}

	public String getFuncion() {
		return funcion;
	}
	
	public String getPeso() {
		return peso;
	}
	
	
	public ArrayList<rob> getrobList() {
		return robList;
	}
}