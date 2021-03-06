package com.ranga.spring.data;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

public class ExtendedRepositoryImpl<T, ID extends Serializable> extends SimpleJpaRepository<T, Serializable>
		implements BaseRepository<T, Serializable> {

	JpaEntityInformation<T, ?> entityInformation;
	EntityManager entityManager;

	public ExtendedRepositoryImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
		super(entityInformation, entityManager);
		this.entityInformation = entityInformation;
		this.entityManager = entityManager;
	}

	@Override
	public List<T> findByIds(Serializable... ids) {
		Query query = this.entityManager.createQuery("select e from " + this.entityInformation.getEntityName()
				+ " e where e." + this.entityInformation.getIdAttribute().getName() + " in :ids");
		query.setParameter("ids", Arrays.asList(ids));

		try {
			long wait = new Random().nextInt(10000 - 1) + 1;
			System.out.println(" >> " + wait);
			Thread.currentThread().sleep(wait);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println(" >> executing " + Arrays.toString(ids));

		return (List<T>) query.getResultList();
	}

}
