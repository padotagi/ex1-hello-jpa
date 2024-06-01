package hellojpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            // insert
//            Member member = new Member();
//            member.setId(1L);
//            member.setName("HelloA");
//            em.persist(member);

            //select
 //           Member findMember = em.find(Member.class, 1L);

            //delete
//            em.remove(findMember);

            //update
//           findMember.setName("HelloJPA");

//            List<Member> resultList = em.createQuery("select m from Member as m", Member.class)
//                   .setFirstResult(5) //페이징
//                    .setMaxResults(8)
//                    .getResultList();

//            for (Member m : resultList) {
//                System.out.println(m.getName());
//            }

            //비영속
//            Member member = new Member();
//            member.setId(101L);
//            member.setName("HelloJPA2");

            //영속
//            System.out.println("===== BEFORE =====");
//            em.persist(member);
//            System.out.println("===== AFTER =====");

//            Member findMember = em.find(Member.class, 101L);
//
//            System.out.println("findMember.id = " + findMember.getId());
//            System.out.println("findMember.name = " + findMember.getName());

            //준영속 detach...

            /* 단방향 연관관계 */
            //저장
            Team team = new Team();
            team.setName("TeamA");
 //           team.getMembers().add(member);
            em.persist(team);

            Member member = new Member();
            member.setUsername("member1");
            member.changeTeam(team);
            em.persist(member);


            em.flush();
            em.clear();

//            Member findMember = em.find(Member.class, member.getId());

//            Team findTeam = findMember.getTeam();
//            System.out.println("findTeam = " + findTeam.getName());
//
//            // FK update
//            Team newTeam = em.find(Team.class, 100L);
//            findMember.setTeam(newTeam);

            /* 양방향 연관관계 */
//            List<Member> members = findMember.getTeam().getMembers();
//            for (Member m : members) {
//                System.out.println("m = " + m.getUsername());
//            }



            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close(); // WAS 가 내려갈 때
    }
}
