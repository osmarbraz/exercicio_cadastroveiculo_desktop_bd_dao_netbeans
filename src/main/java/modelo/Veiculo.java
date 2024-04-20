package modelo;

public class Veiculo {

    private int veiculoId;
    private String placa;
    private String modelo;
    private String marca;
    private String lugares;
    private String valorAluguel;

    public Veiculo() {
        this(-1, "", "", "", "", "");
    }

    public Veiculo(int veiculoId, String placa, String modelo, String marca, String lugares, String valorAluguel) {
        setVeiculoId(veiculoId);
        setPlaca(placa);
        setModelo(modelo);
        setMarca(marca);
        setLugares(lugares);
        setValorAluguel(valorAluguel);
    }

    public int getVeiculoId() {
        return veiculoId;
    }

    public void setVeiculoId(int veiculoId) {
        this.veiculoId = veiculoId;
    }

    public void setVeiculoId(String veiculoId) {
        setVeiculoId(Integer.parseInt(veiculoId));
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getLugares() {
        return lugares;
    }

    public void setLugares(String lugares) {
        this.lugares = lugares;
    }

    public String getValorAluguel() {
        return valorAluguel;
    }

    public void setValorAluguel(String valorAluguel) {
        this.valorAluguel = valorAluguel;
    }

}
