package controller;

import java.sql.SQLException;

import dao.ProfissionalDAO;
import dao.GerenteDAO;
import dao.RecepcionistaDAO;
import dao.ExceptionDAO;

public class LoginController {
    
    private ProfissionalDAO profissionalDAO;
    private GerenteDAO gerenteDAO;
    private RecepcionistaDAO recepcionistaDAO;

    public LoginController() {
        // Inicializando os DAOs para cada tipo de usuário
        this.profissionalDAO = new ProfissionalDAO();
        this.gerenteDAO = new GerenteDAO();
        this.recepcionistaDAO = new RecepcionistaDAO();
    }

    // Método para autenticar o usuário de acordo com o tipo
    public boolean autenticar(String username, String password, String userType) throws SQLException, ExceptionDAO {
        try {
            switch (userType) {
                case "Profissional":
                    return profissionalDAO.autenticarUsuario(username, password);
                case "Gerente":
                    return gerenteDAO.autenticarUsuario(username, password);
                case "Recepcionista":
                    return recepcionistaDAO.autenticarUsuario(username, password);
                default:
                    return false; // Tipo de usuário inválido
            }
        } catch (SQLException e) {
            System.out.println("Erro ao autenticar usuário: " + e.getMessage());
            return false;
        }
    }
}
