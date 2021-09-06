package com.utn.contactservices;

import javax.persistence.AttributeConverter;

public class MedioConverter implements AttributeConverter<IMedio, String>{

    @Override
    public String convertToDatabaseColumn(IMedio attribute) {
        return attribute.getClass().getName();
    }

    @Override
    public IMedio convertToEntityAttribute(String dbData) {
        IMedio medio = null;
        try{
            Class c = Class.forName(dbData);
            medio = (IMedio) c.newInstance();
        }catch (ClassNotFoundException e) {
            e.printStackTrace();    
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return medio;
    }

}