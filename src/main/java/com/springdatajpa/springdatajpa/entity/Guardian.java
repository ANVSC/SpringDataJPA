package com.springdatajpa.springdatajpa.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
@AttributeOverrides({
        @AttributeOverride(name = "name", column = @Column(name = "gaurdian_name")),
        @AttributeOverride(name = "email", column = @Column(name = "gaurdian_email")),
        @AttributeOverride(name = "mobile", column = @Column(name = "gaurdian_mobile"))

})
public class Guardian {

    private String name;

    private String email;

    private String mobile;
}
