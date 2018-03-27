package br.org.emil.import_stock_date.jpa.converter;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.sql.Date;
import java.time.LocalDateTime;
import java.time.ZoneId;
 
@Converter(autoApply = true)
public class LocalDatePersistenceConverter implements AttributeConverter<LocalDateTime, Date> {
 
    @Override
    public Date convertToDatabaseColumn(LocalDateTime entityValue) {
        if(entityValue != null) {
            return new java.sql.Date(Date.from(entityValue.atZone(ZoneId.systemDefault()).toInstant()).getTime()); 
        }
        return null;
    }
 
    @Override
    public LocalDateTime convertToEntityAttribute(Date databaseValue) {
        if(databaseValue != null) {
            return LocalDateTime.ofInstant(databaseValue.toInstant(), ZoneId.systemDefault());
        }
        return null;
    }


}