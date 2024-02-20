package com.enigma.jpa_wmbrod.entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "t_bill", schema = "public", catalog = "wmbrod")
public class Bill {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "trans_date")
    private Date transDate;
    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id", nullable = false)
    private Customer customerByCustomerId;
    @ManyToOne
    @JoinColumn(name = "table_id", referencedColumnName = "id")
    private MTable mTableByTableId;
    @ManyToOne
    @JoinColumn(name = "trans_type", referencedColumnName = "trans_type_id", nullable = false)
    private TransType transTypeByTransType;
    @OneToMany(mappedBy = "billByBillId")
    private Collection<BillDetail> billDetailsById;

    public Bill() {
    }

    public Bill(Date transDate, Customer customerByCustomerId, MTable mTableByTableId, TransType transTypeByTransType) {
        this.transDate = transDate;
        this.customerByCustomerId = customerByCustomerId;
        this.mTableByTableId = mTableByTableId;
        this.transTypeByTransType = transTypeByTransType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getTransDate() {
        return transDate;
    }

    public void setTransDate(Date transDate) {
        this.transDate = transDate;
    }

    public Customer getmCustomerByCustomerId() {
        return customerByCustomerId;
    }

    public void setmCustomerByCustomerId(Customer customerByCustomerId) {
        this.customerByCustomerId = customerByCustomerId;
    }

    public MTable getmTableByTableId() {
        return mTableByTableId;
    }

    public void setmTableByTableId(MTable mTableByTableId) {
        this.mTableByTableId = mTableByTableId;
    }

    public TransType getmTransTypeByTransType() {
        return transTypeByTransType;
    }

    public void setmTransTypeByTransType(TransType transTypeByTransType) {
        this.transTypeByTransType = transTypeByTransType;
    }

    public Collection<BillDetail> gettBillDetailsById() {
        return billDetailsById;
    }

    public void settBillDetailsById(Collection<BillDetail> billDetailsById) {
        this.billDetailsById = billDetailsById;
    }
}
