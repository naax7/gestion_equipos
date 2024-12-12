package Jugadores;

import jakarta.persistence.*;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Jugadores");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        Jugador torres = em.find(Jugador.class, 2);
        Equipo equipo = em.find(Equipo.class, 1);
        tx.commit();

        tx.begin();
        //Jugador jugador = new Jugador("Pepito", 1.70f, 75.0f, equipo);
        //em.persist(jugador);

        Jugador cristiano = em.find(Jugador.class, 1);
        cristiano.setNombre("Cristiana");
        cristiano.setEstatura(1.95f);
        em.merge(cristiano);
        tx.commit();

        tx.begin();
        //em.remove(em.find(Jugador.class, 5));
        TypedQuery<Jugador> j = em.createQuery("SELECT e FROM Jugador e", Jugador.class);
        tx.commit();

        System.out.println(torres);
        //System.out.println(jugador);
        System.out.println(cristiano);
        System.out.println(j.getResultList());
    }
}
