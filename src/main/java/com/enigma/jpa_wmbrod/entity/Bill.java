package com.enigma.jpa_wmbrod.entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "t_bill", schema = "public", catalog = "wmbrod")
public class Bill {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "trans_date", nullable = false)
    private Date transDate;
    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id", nullable = false)
    private Customer mCustomerByCustomerId;
    @ManyToOne
    @JoinColumn(name = "table_id", referencedColumnName = "id")
    private MTable mTableByTableId;
    @ManyToOne
    @JoinColumn(name = "trans_type", referencedColumnName = "trans_type_id", nullable = false)
    private TransType mTransTypeByTransType;
    @OneToMany(mappedBy = "tBillByBillId")
    private Collection<BillDetail> tBillDetailsById;

    public Bill() {
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
        return mCustomerByCustomerId;
    }

    public void setmCustomerByCustomerId(Customer mCustomerByCustomerId) {
        this.mCustomerByCustomerId = mCustomerByCustomerId;
    }

    public MTable getmTableByTableId() {
        return mTableByTableId;
    }

    public void setmTableByTableId(MTable mTableByTableId) {
        this.mTableByTableId = mTableByTableId;
    }

    public TransType getmTransTypeByTransType() {
        return mTransTypeByTransType;
    }

    public void setmTransTypeByTransType(TransType mTransTypeByTransType) {
        this.mTransTypeByTransType = mTransTypeByTransType;
    }

    public Collection<BillDetail> gettBillDetailsById() {
        return tBillDetailsById;
    }

    public void settBillDetailsById(Collection<BillDetail> tBillDetailsById) {
        this.tBillDetailsById = tBillDetailsById;
    }
}
