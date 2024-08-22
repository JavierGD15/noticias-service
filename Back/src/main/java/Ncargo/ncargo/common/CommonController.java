package Ncargo.ncargo.common;

import org.springframework.beans.factory.annotation.Autowired;

public class CommonController <E, S extends CommonSvc<E>, V extends CommonValidatorSvc<E>> {

    @Autowired
    protected S service;

    @Autowired
    protected V validator;

}