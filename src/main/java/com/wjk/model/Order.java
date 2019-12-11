package com.wjk.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "t_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "ddhao")
    private String ddhao;

    @Column(name = "userid")
    private Integer userid;

    @Column(name = "jine")
    private Integer jine;

    @Column(name = "zt")
    private Integer zt;

    @Column(name = "reqi")
    private Date reqi;

    @Column(name = "sfsc")
    private String sfsc;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(
            name = "userid",
            referencedColumnName = "id",insertable = false,updatable = false
    )
    private User user;
}
