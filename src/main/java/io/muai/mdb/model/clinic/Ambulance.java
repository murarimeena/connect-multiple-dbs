package io.muai.mdb.model.clinic;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Table(name = "ambulance_tb")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ambulance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "aName")
    private String aName;
    @Column(name = "city")
    private String city;
    @Column(name = "route")
    private String route;

}