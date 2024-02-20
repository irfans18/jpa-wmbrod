package com.enigma.jpa_wmbrod.entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "t_bill", schema = "public", catalog = "wmbrod")
public class TBill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic
    @Column(name = "trans_date", nullable = false)
    private Date transDate;
    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id", nullable = false)
    private MCustomer mCustomerByCustomerId;
    @ManyToOne
    @JoinColumn(name = "table_id", referencedColumnName = "id")
    private MTable mTableByTableId;
    @ManyToOne
    @JoinColumn(name = "trans_type", referencedColumnName = "trans_type_id", nullable = false)
    private MTransType mTransTypeByTransType;
    @OneToMany(mappedBy = "tBillByBillId")
    private Collection<TBillDetail> tBillDetailsById;

    public TBill() {
    }

    public TBill(Long id, Date transDate, MCustomer mCustomerByCustomerId, MTable mTableByTableId, MTransType mTransTypeByTransType, Collection<TBillDetail> tBillDetailsById) {
        this.id = id;
        this.transDate = transDate;
        this.mCustomerByCustomerId = mCustomerByCustomerId;
        this.mTableByTableId = mTableByTableId;
        this.mTransTypeByTransType = mTransTypeByTransType;
        this.tBillDetailsById = tBillDetailsById;
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

    public MCustomer getmCustomerByCustomerId() {
        return mCustomerByCustomerId;
    }

    public void setmCustomerByCustomerId(MCustomer mCustomerByCustomerId) {
        this.mCustomerByCustomerId = mCustomerByCustomerId;
    }

    public MTable getmTableByTableId() {
        return mTableByTableId;
    }

    public void setmTableByTableId(MTable mTableByTableId) {
        this.mTableByTableId = mTableByTableId;
    }

    public MTransType getmTransTypeByTransType() {
        return mTransTypeByTransType;
    }

    public void setmTransTypeByTransType(MTransType mTransTypeByTransType) {
        this.mTransTypeByTransType = mTransTypeByTransType;
    }

    public Collection<TBillDetail> gettBillDetailsById() {
        return tBillDetailsById;
    }

    public void settBillDetailsById(Collection<TBillDetail> tBillDetailsById) {
        this.tBillDetailsById = tBillDetailsById;
    }
}
