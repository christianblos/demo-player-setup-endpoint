package com.example.demo.playersetup;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Base configuration class that contain a reference to the related entity.
 */
public abstract class GivenEntity<G, E> {

	private AtomicReference<E> entityReference = new AtomicReference<>();

	@SuppressWarnings("unchecked")
	public G entityRef(AtomicReference<E> ref) {
		if (entityReference.get() != null) {
			ref.set(entityReference.get());
		}
		entityReference = ref;
		return (G) this;
	}

	public E getEntity() {
		var entity = entityReference.get();
		if (entity == null) {
			throw new IllegalStateException("Entity not set");
		}
		return entity;
	}

	public void setEntity(E entity) {
		entityReference.set(entity);
	}

}