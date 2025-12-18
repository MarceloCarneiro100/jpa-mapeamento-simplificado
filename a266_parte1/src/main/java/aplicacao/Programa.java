package aplicacao;

import dominio.Pessoa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Programa {
    public static void main(String[] args) {

        // Ao criar novas pessoas, o id é null.
        // O banco de dados (com auto-incremento) atribui o id automaticamente.
        Pessoa p1 = new Pessoa(null, "Carlos da Silva", "carlos@gmail.com");
        Pessoa p2 = new Pessoa(null, "Joaquim Torres", "joaquim@gmail.com");
        Pessoa p3 = new Pessoa(null, "Ana Maria", "ana@gmail.com");

        // Cria a fábrica de EntityManager com base na unidade de persistência
        // definida em META-INF/persistence.xml (name="exemplo-jpa").
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
        EntityManager em = emf.createEntityManager();

        // Operações de escrita (insert, update, delete) precisam estar dentro de uma transação.
        em.getTransaction().begin();

        // Persistindo (inserindo) entidades no banco.
        em.persist(p1);
        em.persist(p2);
        em.persist(p3);

        // Removendo uma entidade do banco.
        // Só é possível remover entidades que estão gerenciadas pelo EntityManager
        // (recuperadas via find ou recém-persistidas).
        Pessoa p4 = em.find(Pessoa.class, 2);
        em.remove(p4);

        // Exemplo de entidade não gerenciada (não pode ser removida diretamente):
        // Pessoa p5 = new Pessoa(2, null, null);

        // Confirma todas as operações feitas na transação.
        em.getTransaction().commit();

        // Consultas simples (find) não precisam de transação.
        Pessoa p5 = em.find(Pessoa.class, 3);
        System.out.println(p5);

        // Fecha os recursos.
        em.close();
        emf.close();

        System.out.println("Pronto!");
    }
}

