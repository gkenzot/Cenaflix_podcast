/*
 * Copyright (C) 2024 kenzo
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package br.com.senac.cenaflix_podcast.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Classe responsável pela interação com o banco de dados para operações
 * relacionadas a usuários.
 *
 * Esta classe possui um método para validar um usuário no banco de dados,
 * recebendo um usuário como entrada e retornando o usuário correspondente, se
 * encontrado, ou null caso contrário.
 *
 * Utiliza uma conexão JDBC para executar consultas parametrizadas no banco de
 * dados MySQL.
 *
 * @author kenzo
 */
public class UsuarioBD {

    /**
     * Valida um usuário no banco de dados.
     *
     * @param usuario O usuário a ser validado.
     * @return O usuário correspondente se encontrado, ou null caso contrário.
     */
    public static Usuario validarUsuarioSeguro(Usuario usuario) {

        // Criando consulta parametrizada
        String sql = "SELECT * FROM usuario WHERE login = ? AND senha = ?";
        Usuario usuarioEncontrado = null;
        try {
            Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/cenaflix_podcast", "root", "123456");
            PreparedStatement statement = conexao.prepareStatement(sql);
            // Atribuindo os valores na consulta
            statement.setString(1, usuario.getLogin());
            statement.setString(2, usuario.getSenha());
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                usuarioEncontrado = new Usuario();
                usuarioEncontrado.setId(rs.getInt("id"));
                usuarioEncontrado.setNome(rs.getString("nome"));
                usuarioEncontrado.setLogin(rs.getString("login"));
                usuarioEncontrado.setSenha(rs.getString("senha"));
                usuarioEncontrado.setTipo(rs.getString("tipo"));
            }
        } catch (SQLException ex) {
            System.out.println("Sintaxe de comando invalida");
        }
        return usuarioEncontrado;
    }

}
