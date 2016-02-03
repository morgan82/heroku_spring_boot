package com.globallogic.orders.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import java.util.Date;

@Entity
@Table(name = "Orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public class Order {

    @Id
    private String id;
    @NotNull
    @JsonFormat(pattern = "yyyyMMdd")
    private Date date;
    @NotNull
    @Size(min = 3, max = 20, message = "Invalide size of order.userId (3, 20)")
    private String userId;
    @NotNull
    @DecimalMin(value = "0", message = "la ocurrencia no debe ser negativa")
    private Integer occs = 0;


    public void incrementOccur() {
        this.occs++;
    }

    public void decrementOccur() {
        if (this.occs > 0) {
            this.occs--;
        }
    }

}
