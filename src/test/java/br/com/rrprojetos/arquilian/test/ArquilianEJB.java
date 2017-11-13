package br.com.rrprojetos.arquilian.test;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@Local
public class ArquilianEJB {

	@PersistenceContext
	private EntityManager em;

	public void save(Person p) {
		em.persist(p);
	}

	public void update(Person p) {
		em.merge(p);
	}

	public Person seek(int id) {
		return em.find(Person.class, id);
	}

	public List<Person> searchAllPersons () {
		return  em.createQuery("SELECT p FROM Person p ORDER BY p.id", Person.class).getResultList ();
    }
}
