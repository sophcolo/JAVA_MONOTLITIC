package com.api.web.interfaces;

import java.util.List;

import com.api.web.exceptions.ApiNotFound;
import com.api.web.exceptions.ApiUnprocessableEntity;

public interface BaseServiceInterface<T,D,K> {
	public List<T> all();
	public T getById(K pK) throws ApiNotFound;
	public T save(D usr) throws ApiUnprocessableEntity, ApiNotFound;
	public T udpate(K pK, D dto) throws ApiUnprocessableEntity,ApiNotFound;
	public void delete(K pK) throws ApiNotFound;
}