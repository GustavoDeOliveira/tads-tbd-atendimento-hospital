package apresentacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import negocio.Setor;
import negocio.Funcionario;

public class Main {
    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("AtendimentoHospitalPU");
    

    public static void main(String[] args) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        Funcionario gustavo = new Funcionario();
        Setor s = new Setor("Enfermagem");
        gustavo.setNome("Gustavo");
        gustavo.setSetor(s);
        em.persist(s);
        em.persist(gustavo);
        em.getTransaction().commit();
        
        Setor sresult = em.createQuery("SELECT s FROM Setor s WHERE s.id = :id", Setor.class)
                .setParameter("id", s.getId())
                .getSingleResult();
        
        System.out.print("setor: " + sresult.getDescricao() + ", funcionarios: " + sresult.getFuncionarios().size() + ", nomes: ");
        sresult.getFuncionarios().forEach(f -> System.out.print(f.getNome() + ", "));
        em.close();
    }
}
