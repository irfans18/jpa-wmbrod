package com.enigma.jpa_wmbrod.entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "t_bill", schema = "public", catalog = "wmbrod")
public class TBill {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private long id;
    @Basic
    @Column(name = "trans_date", nullable = false)
    private Date transDate;
    @Basic
    @Column(name = "customer_id", nullable = false)
    private long customerId;
    @Basic
    @Column(name = "table_id", nullable = true)
    private Integer tableId;
    @Basic
    @Column(name = "trans_type", nullable = false, length = 3)
    private String transType;
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getTransDate() {
        return transDate;
    }

    public void setTransDate(Date transDate) {
        this.transDate = transDate;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public Integer getTableId() {
        return tableId;
    }

    public void setTableId(Integer tableId) {
        this.tableId = tableId;
    }

    public String getTransType() {
        return transType;
    }

    public void setTransType(String transType) {
        this.transType = transType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TBill tBill = (TBill) o;
        return id == tBill.id && customerId == tBill.customerId && Objects.equals(transDate, tBill.transDate) && Objects.equals(tableId, tBill.tableId) && Objects.equals(transType, tBill.transType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, transDate, customerId, tableId, transType);
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
