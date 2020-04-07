package com.billfelipe.framework.web;

import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.billfelipe.framework.model.BaseModel;

@FacesConverter(value = "baseModelConverter", forClass = BaseModel.class)
public class BaseModelConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext ctx, UIComponent component, String value) {
        if (value == null) {
            return null;
        }

        return this.getAttributesFrom(component).get(value);
    }

    @Override
    public String getAsString(FacesContext ctx, UIComponent component, Object value) {

        if ((value != null) && !"".equals(value)) {
            BaseModel entity = (BaseModel) value;

            if (entity.getId() != null) {
                this.addAttribute(component, entity);

                if (entity.getId() != null) {
                    return String.valueOf(entity.getId());
                }
                return (String) value;
            }
        }
        return "";
    }

    private void addAttribute(UIComponent component, BaseModel o) {
        this.getAttributesFrom(component).put(o.getId().toString(), o);
    }

    private Map<String, Object> getAttributesFrom(UIComponent component) {
        return component.getAttributes();
    }

}