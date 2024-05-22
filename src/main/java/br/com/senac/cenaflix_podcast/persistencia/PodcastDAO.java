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
import jakarta.persistence.Query;
import java.util.List;

/**
 * Classe responsável pela persistência de podcasts no banco de dados.
 *
 * Fornece métodos para cadastrar, listar, excluir, obter e atualizar podcasts.
 * Utiliza o JPA para interagir com o banco de dados.
 *
 * @author kenzo
 */
public class PodcastDAO {

    /**
     * Cadastra um novo podcast no banco de dados.
     *
     * @param p O podcast a ser cadastrado.
     */
    public void cadastrar(Podcast p) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(p); // breakpoint
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            JPAUtil.closeEtityManager();
        }
    }

    /**
     * Lista todos os podcasts armazenados no banco de dados.
     *
     * @param produtorPesquisar O nome do produtor para filtrar a busca. Pode
     * ser nulo para buscar todos os podcasts.
     * @return Uma lista de podcasts que correspondem ao filtro de busca.
     */
    public List<Podcast> listar(String produtorPesquisar) {
        EntityManager em = JPAUtil.getEntityManager();
        List podcasts = null;
        try {
            String textoQuery = "SELECT p FROM Podcast p " + " WHERE (:produtor is null OR p.produtor LIKE :produtor ) ";
            Query consulta = em.createQuery(textoQuery); // breakpoint
            consulta.setParameter("produtor", produtorPesquisar.isEmpty() ? null : "%" + produtorPesquisar + "%");
            podcasts = consulta.getResultList(); //breakpoint
        } finally {
            JPAUtil.closeEtityManager();
        }
        return podcasts;
    }

    /**
     * Exclui um podcast do banco de dados com base no seu ID.
     *
     * @param id O ID do podcast a ser excluído.
     */
    public void excluir(int id) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            Podcast d = em.find(Podcast.class, id); //breakpoint
            if (d != null) {
                em.getTransaction().begin();
                em.remove(d); // breakpoint
                em.getTransaction().commit();
            }
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            JPAUtil.closeEtityManager();
        }
    }

    /**
     * Obtém um podcast do banco de dados com base no seu ID.
     *
     * @param id O ID do podcast a ser obtido.
     * @return O podcast correspondente ao ID fornecido.
     */
    public Podcast obter(int id) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.find(Podcast.class, id); // breakpoint
        } finally {
            JPAUtil.closeEtityManager();
        }
    }

    /**
     * Atualiza as informações de um podcast no banco de dados.
     *
     * @param p O podcast com as informações atualizadas.
     */
    public void atualizar(Podcast p) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(p); // breakpoint
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            JPAUtil.closeEtityManager();
        }
    }

}
