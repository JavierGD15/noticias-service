package Ncargo.ncargo.validator;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import Ncargo.ncargo.common.CommonValidatorSvc;
import Ncargo.ncargo.models.clasificacionModel;

@Component("clasificacionValidator")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class clasificacionValidator implements CommonValidatorSvc<clasificacionModel> {

    @Override
    public clasificacionModel validate(clasificacionModel e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'validate'");
    }

}
