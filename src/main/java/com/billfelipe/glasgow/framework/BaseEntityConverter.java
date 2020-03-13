package com.billfelipe.glasgow.framework;

import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "baseEntityConverter", forClass = BaseEntity.class)
public class BaseEntityConverter implements Converter {

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
            BaseEntity entity = (BaseEntity) value;

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

    private void addAttribute(UIComponent component, BaseEntity o) {
        this.getAttributesFrom(component).put(o.getId().toString(), o);
    }

    private Map<String, Object> getAttributesFrom(UIComponent component) {
        return component.getAttributes();
    }

}