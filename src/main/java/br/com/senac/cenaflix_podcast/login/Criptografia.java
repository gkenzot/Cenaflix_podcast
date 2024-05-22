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

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * A classe Criptografia fornece métodos estáticos para criptografar textos usando o algoritmo MD5.
 * 
 * Esta classe utiliza a implementação do algoritmo de hash MD5 fornecida pelo pacote java.security.
 * 
 * @author kenzo
 */
public class Criptografia {

    /**
     * Retorna a representação hexadecimal da hash MD5 do texto fornecido.
     * 
     * @param texto O texto a ser criptografado.
     * @return A representação hexadecimal da hash MD5 do texto.
     */
    public static String getMD5(String texto) {
        try {
            // O método estático getInstance é chamado com hash MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
            // O método digest() é chamado para calcular a hash da mensagem 
            // E enfim temos o vetor da mensagem
            byte[] messageDigest = md.digest(texto.getBytes());
            // Convertemos o vetor de bytes em um BigInt 
            BigInteger no = new BigInteger(1, messageDigest);
            // A mensagem em BigInt é convertid a para hexadecimal 
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        } 
        // Em caso de erro, é lançada uma exceção
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
