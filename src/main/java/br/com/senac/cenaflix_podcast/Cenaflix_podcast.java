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

package br.com.senac.cenaflix_podcast;

import br.com.senac.cenaflix_podcast.gui.Login;

/**
 * Classe principal que inicializa o sistema Cenaflix Podcast.
 */
public class Cenaflix_podcast {

    /**
     * O método inicializador do programa
     *
     * @param args Os argumentos da linha de comando (não utilizados neste programa).
     */
    public static void main(String[] args) {
        // Inicializa a interface gráfica do usuário dentro do thread de eventos AWT/Swing.
        java.awt.EventQueue.invokeLater(() -> {
            new Login().setVisible(true);
        });
    }
}
