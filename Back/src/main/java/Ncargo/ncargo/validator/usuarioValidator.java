package Ncargo.ncargo.validator;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import Ncargo.ncargo.common.CommonValidatorSvc;

import Ncargo.ncargo.models.ususarioModel;

@Component("usuarioValidator")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class usuarioValidator implements CommonValidatorSvc<ususarioModel> {


    @Override
    public ususarioModel validate(ususarioModel e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'validate'");
    }
    
}
