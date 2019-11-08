import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class doa {
	private static EntityManagerFactory entityManagerFactory;
	
	public void addProducts() throws Validation {
		entityManagerFactory = HibernateOGMUtil.getEntityManagerFactory();

		EntityManager em = entityManagerFactory.createEntityManager();
		
		Scanner s=new Scanner(System.in);
		System.out.println("Name:");
		String name=s.next();
		if(name=="")
		{
			throw new Validation("No name");
		}
		System.out.println("Description:");
		
		String description=s.next();
		if(description=="")
		{
			throw new Validation("No Description");
		}
		System.out.println("Price:");
		
		int price=s.nextInt();
		System.out.println("Quantity:");
		int quantity=s.nextInt();
		
		
		Products sd=new Products(name,description,price,quantity);
		
		em.getTransaction().begin();
		em.persist(sd);
		em.getTransaction().commit();
	}
	
	public void updateProduct(String name) throws Validation{
		entityManagerFactory = HibernateOGMUtil.getEntityManagerFactory();

		EntityManager em = entityManagerFactory.createEntityManager();
		Products product=em.createQuery("select s from Products s where name= :name",Products.class).setParameter("name",name).getResultList().get(0);
		Scanner s=new Scanner(System.in);
		System.out.println("Name:");
		String name1=s.next();
		if(name1=="")
		{
			throw new Validation("No name");
		}
		System.out.println("Description:");
		String description=s.next();
		if(description=="")
		{
			throw new Validation("No Description");
		}
		System.out.println("Price:");
		int price=s.nextInt();
		System.out.println("Quantity:");
		int quantity=s.nextInt();
		product.setName(name1);
		product.setDescription(description);
		product.setPrice(price);
		product.setQuantity(quantity);
		em.getTransaction().begin();
		em.merge(product);
		em.getTransaction().commit();
	}
	
	public List<Products> printProducts(){
		entityManagerFactory = HibernateOGMUtil.getEntityManagerFactory();

		EntityManager em = entityManagerFactory.createEntityManager();
		return em.createQuery("select s from Products s",Products.class).setFirstResult(0).setMaxResults(3).getResultList();
	
	}
	
	public void deleteProduct(String name)
	{
		entityManagerFactory = HibernateOGMUtil.getEntityManagerFactory();

		EntityManager em = entityManagerFactory.createEntityManager();
		Products product=em.createQuery("select s from Products s where name= :name",Products.class).setParameter("name",name).getResultList().get(0);
	
		em.getTransaction().begin();
		em.remove(product);
		em.getTransaction().commit();
		
	
	}
}
