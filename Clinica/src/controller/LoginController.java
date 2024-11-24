package controller;

import java.sql.SQLException;

import dao.ExceptionDAO;
import dao.FuncionarioDAO;

public class LoginController {
    
    private FuncionarioDAO funcionarioDAO;

    public LoginController() {
        this.funcionarioDAO = new FuncionarioDAO();
    }

    
    public boolean autenticar(String username, String password, String userType) throws SQLException, ExceptionDAO {
        switch (userType) {
		    case "Profissional":
		        return funcionarioDAO.autenticarFuncionario(username, password);
		    case "Gerente":
		        return funcionarioDAO.autenticarFuncionario(username, password);
		    case "Recepcionista":
		        return funcionarioDAO.autenticarFuncionario(username, password);
		    default:
		        return false;
		}
    }
}
