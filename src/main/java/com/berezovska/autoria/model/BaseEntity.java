package com.berezovska.autoria.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.Expose;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@NoArgsConstructor
public abstract @Data class BaseEntity {

    @Id
    @JsonProperty("value")
    @Expose
    //@GeneratedValue (strategy = GenerationType.AUTO)
    private int id;

   @Override
    public String toString () {
        final StringBuilder sb = new StringBuilder(("BaseEntity{"));
        sb.append("id=").append(id);
        sb.append("}");
        return sb.toString();
    }
}
