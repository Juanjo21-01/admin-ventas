package com.proyecto.ventas.validator;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.proyecto.ventas.common.CommonValidatorSvc;
import com.proyecto.ventas.models.usuariosModel;

@Component("usuariosValidator")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class usuariosValidator implements CommonValidatorSvc<usuariosModel> {


    @Override
    public usuariosModel validate(usuariosModel e) {
        throw new UnsupportedOperationException("Unimplemented method 'validate'");
    }
    
}