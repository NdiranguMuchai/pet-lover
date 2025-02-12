package com.ndirangu.petlover.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "types")
public class PetType extends BaseEntity{
    @Builder
    public PetType(Long id, String name){
        super(id);
        this.name = name;
    }

    @Column(name = "name")
    private String name;

    /**
     * To string ensures that instead of returning the object in this case you return the name
     */

    @Override
    public String toString() {
        return name;
    }
}
