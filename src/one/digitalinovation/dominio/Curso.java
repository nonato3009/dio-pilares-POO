package one.digitalinovation.dominio;

public class Curso extends Conteudo {
	
	private int cargaHorária;
	
	@Override
	public double calcularXp() {
		return XP_PADRAO * cargaHorária;
	}
	
	public int getCargaHorária() {
		return cargaHorária;
	}
	public void setCargaHorária(int cargaHorária) {
		this.cargaHorária = cargaHorária;
	}
	
}
