package dao.veiculo;

import dao.Conexao;
import dao.DadosBanco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Veiculo;

public class VeiculoDAOMySQL implements VeiculoDAO {

    public boolean salvar(Veiculo veiculo) {
        boolean resultado = false;
        Conexao MinhaConexao = new Conexao(DadosBanco.SERVIDOR, DadosBanco.DATABASE, DadosBanco.USUARIO, DadosBanco.SENHA);
        MinhaConexao.conectar();
        Connection conn = MinhaConexao.getCon();
        PreparedStatement pstmt = null;
        try {
            String sql = null;
            if (veiculo.getVeiculoId() != -1) {
                sql = "update veiculo set PLACA = ?, MODELO = ?, MARCA=?, LUGARES=?, VALORALUGUEL=? where VEICULOID = ?";
            } else {
                sql = "insert into veiculo (PLACA, MODELO, MARCA, LUGARES, VALORALUGUEL)  values  (?,?,?,?,?)";
            }
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, veiculo.getPlaca());
            pstmt.setString(2, veiculo.getModelo());
            pstmt.setString(3, veiculo.getMarca());
            pstmt.setString(4, veiculo.getLugares());
            pstmt.setString(5, veiculo.getValorAluguel());
            if (veiculo.getVeiculoId() != -1) {
                pstmt.setInt(6, veiculo.getVeiculoId());
            }

            pstmt.executeUpdate();
            resultado = true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return resultado;
    }

    public List consultarTudo() {
        Veiculo veiculo = null;
        Conexao MinhaConexao = new Conexao(DadosBanco.SERVIDOR, DadosBanco.DATABASE, DadosBanco.USUARIO, DadosBanco.SENHA);
        MinhaConexao.conectar();
        Connection conn = MinhaConexao.getCon();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList<Veiculo> lista = new ArrayList<Veiculo>();
        try {
            String sql = "select * from veiculo";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                veiculo = new Veiculo();
                veiculo.setVeiculoId(rs.getInt("veiculoId"));
                veiculo.setPlaca(rs.getString("placa"));
                veiculo.setModelo(rs.getString("modelo"));
                veiculo.setMarca(rs.getString("marca"));
                veiculo.setLugares(rs.getString("lugares"));
                veiculo.setValorAluguel(rs.getString("valorAluguel"));
                lista.add(veiculo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return lista;
    }

    public boolean apagarPK(int veiculoId) {
        boolean resultado = false;
        Conexao MinhaConexao = new Conexao(DadosBanco.SERVIDOR, DadosBanco.DATABASE, DadosBanco.USUARIO, DadosBanco.SENHA);
        MinhaConexao.conectar();
        Connection conn = MinhaConexao.getCon();
        PreparedStatement pstmt = null;
        try {
            String sql = "delete from veiculo where veiculoId = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, veiculoId);
            pstmt.executeUpdate();
            resultado = true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return resultado;
    }

    public Veiculo consultarPK(String veiculoId) {
        Veiculo veiculo = null;
        Conexao MinhaConexao = new Conexao(DadosBanco.SERVIDOR, DadosBanco.DATABASE, DadosBanco.USUARIO, DadosBanco.SENHA);
        MinhaConexao.conectar();
        Connection conn = MinhaConexao.getCon();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from veiculo where veiculoId = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, Integer.parseInt(veiculoId));
            rs = pstmt.executeQuery();
            while (rs.next()) {
                veiculo = new Veiculo();
                veiculo.setVeiculoId(rs.getString("veiculoId"));
                veiculo.setPlaca(rs.getString("placa"));
                veiculo.setModelo(rs.getString("modelo"));
                veiculo.setMarca(rs.getString("marca"));
                veiculo.setLugares(rs.getString("lugares"));
                veiculo.setValorAluguel(rs.getString("valorAluguel"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return veiculo;
    }

    public int reajustar(double percentual) {
        int resultado = 0;
        Conexao MinhaConexao = new Conexao(DadosBanco.SERVIDOR, DadosBanco.DATABASE, DadosBanco.USUARIO, DadosBanco.SENHA);
        MinhaConexao.conectar();
        Connection conn = MinhaConexao.getCon();
        PreparedStatement pstmt = null;
        try {
            String sql = "update veiculo set valorAluguel =  valorAluguel + valorAluguel * ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setDouble(1, percentual / 100.0);
            resultado = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return resultado;
    }
}
