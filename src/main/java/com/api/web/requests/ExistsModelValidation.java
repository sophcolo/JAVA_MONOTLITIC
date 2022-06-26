package com.api.web.requests;

import com.api.web.exceptions.ApiNotFound;

public interface ExistsModelValidation<T,U> {
	void validatorIndentity(T model,U paramKey ) throws ApiNotFound;
}
