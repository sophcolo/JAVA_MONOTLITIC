package com.api.web.requests.users;

import org.springframework.stereotype.Service;
import com.api.web.exceptions.ApiUnprocessableEntity;

/**
 * Interface for Validation of data of creation of Device Catalog
 * @author Jonathan Colorado
 * @date 19-06-2022
 */
@Service
public interface EntityValidatorInterface<T> {
	void validatorRequest(T request) throws ApiUnprocessableEntity;
}