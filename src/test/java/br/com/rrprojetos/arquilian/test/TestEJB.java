package br.com.rrprojetos.arquilian.test;

import java.util.List;

import javax.ejb.EJB;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class TestEJB {

	@EJB
	private ArquilianEJB ejb;

	@Deployment
	public static Archive<?> createFileTest() {
		Archive<?> arquivoTest = ShrinkWrap.create(WebArchive.class, "applicationTest.war")
				.addPackage(Person.class.getPackage()).addClasses(Person.class, ArquilianEJB.class)
				.addAsResource("META-INF/persistence.xml").addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
		return arquivoTest;
	}

	@Test
	public void testSearchAllPersons() {
		List<Person> persons = ejb.searchAllPersons();
		Assert.assertNotNull(persons);
	}
}
