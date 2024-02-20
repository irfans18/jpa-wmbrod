package com.enigma.jpa_wmbrod.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "m_table")
public class TableMenu {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "table_seq")
    @SequenceGenerator(name = "table_seq", sequenceName = "m_table_seq", allocationSize = 1)
    private Integer id;
    @Column(name = "table_name")
    private String name;

    public TableMenu() {
    }

    public TableMenu(Integer id) {
        this.id = id;
    }

    public TableMenu(String name) {
        this.name = name;
    }

    public TableMenu(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
