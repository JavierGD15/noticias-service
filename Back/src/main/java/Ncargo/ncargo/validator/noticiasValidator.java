package Ncargo.ncargo.validator;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import Ncargo.ncargo.common.CommonValidatorSvc;
import Ncargo.ncargo.models.noticiasModel;

@Component("noticiasValidator")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class noticiasValidator implements CommonValidatorSvc<noticiasModel> {

    

    @Override
    public noticiasModel validate(noticiasModel e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'validate'");
    }
    
}
