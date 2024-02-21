package com.enigma.jpa_wmbrod.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "t_bill")
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bill_seq")
    @SequenceGenerator(name = "bill_seq", sequenceName = "t_bill_id_seq", allocationSize = 1)
    private Long id;
    @Column(name = "trans_date", nullable = false)
    private Date date;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @OneToOne
    @JoinColumn(name = "table_id")
    private TableMenu tableMenu;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "trans_type")
    private TransType transType;
    @OneToMany(mappedBy = "billId", cascade = CascadeType.PERSIST)
    private List<BillDetail> billDetails;

    public Bill() {
        this.billDetails = new ArrayList<>();
    }

    public Bill(Long id, Date date, Customer customer, TableMenu tableMenu, TransType transType, List<BillDetail> billDetails) {
        this.id = id;
        this.date = date;
        this.customer = customer;
        this.tableMenu = tableMenu;
        this.transType = transType;
        this.billDetails = billDetails;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public TableMenu getTableMenu() {
        return tableMenu;
    }

    public void setTableMenu(TableMenu tableMenu) {
        this.tableMenu = tableMenu;
    }

    public TransType getTransType() {
        return transType;
    }

    public void setTransType(TransType transType) {
        this.transType = transType;
    }

    public List<BillDetail> getBillDetails() {
        return billDetails;
    }

    public void setBillDetails(List<BillDetail> billDetails) {
        this.billDetails = billDetails;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bill bill = (Bill) o;
        return Objects.equals(id, bill.id) && Objects.equals(date, bill.date) && Objects.equals(customer, bill.customer) && Objects.equals(tableMenu, bill.tableMenu) && Objects.equals(transType, bill.transType) && Objects.equals(billDetails, bill.billDetails);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, customer, tableMenu, transType, billDetails);
    }
}
