package com.api.web.requests;

import org.springframework.stereotype.Service;
import com.api.web.dtos.DeviceCatalogRequest;
import com.api.web.exceptions.ApiNotFound;
import com.api.web.exceptions.ApiUnprocessableEntity;

/**
 * Interface for Validation of data of creation of Device Catalog
 * @author Jonathan Colorado
 * @date 19-06-2022
 */
@Service
public interface ModelValidatorInterface {
	void validatorRequest(DeviceCatalogRequest request ) throws ApiUnprocessableEntity;
	void validatorIndentity(String paramModel ) throws ApiNotFound;
}
