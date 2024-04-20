package dao.veiculo;

import java.util.List;
import modelo.Veiculo;

public interface VeiculoDAO {

    public boolean salvar(Veiculo veiculo);

    public Veiculo consultarPK(String veiculoId);

    public boolean apagarPK(int veiculoId);

    public List consultarTudo();

    public int reajustar(double percentual);
}
