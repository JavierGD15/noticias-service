package Ncargo.ncargo.validator;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import Ncargo.ncargo.common.CommonValidatorSvc;
import Ncargo.ncargo.models.biblioteca;

@Component("bibliotecaValidator")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class bibliotecaValidator implements CommonValidatorSvc<biblioteca> {

    @Override
    public biblioteca validate(biblioteca e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'validate'");
    }
    
}
