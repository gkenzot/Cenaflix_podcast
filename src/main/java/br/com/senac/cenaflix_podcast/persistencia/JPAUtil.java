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
package br.com.senac.cenaflix_podcast.persistencia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 * Classe utilitária para obter o EntityManagerFactory e o EntityManager do JPA.
 *
 * Esta classe fornece métodos estáticos para obter e fechar o EntityManager e o
 * EntityManagerFactory. Utiliza o padrão Singleton para garantir que apenas uma
 * instância do EntityManagerFactory seja criada.
 *
 * @author kenzo
 */
public class JPAUtil {
// constante para centralizar o nome da unidade de persistência
// se o nome mudar, precisaremos alterar em um só lugar

    private static final String PERSISTENCE_UNIT = "cenaflix_podcast";
    private static EntityManager em;
    private static EntityManagerFactory fabrica;
    //cria a entidade se estiver nula e a retorna

    /**
     * Obtém o EntityManager para interagir com a unidade de persistência.
     *
     * @return O EntityManager para a unidade de persistência.
     */
    public static EntityManager getEntityManager() {
        if (fabrica == null || !fabrica.isOpen()) {
            fabrica = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        }
        if (em == null || !em.isOpen()) //cria se em nulo ou se o entity manager foi fechado
        {

        }
        em = fabrica.createEntityManager();
        return em;
    }

    /**
     * Fecha o EntityManager e o EntityManagerFactory.
     */
    public static void closeEtityManager() {
        if (em.isOpen() && em != null) {
            em.close();
            fabrica.close();
        }

    }
}
