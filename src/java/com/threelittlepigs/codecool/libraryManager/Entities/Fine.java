package com.threelittlepigs.codecool.libraryManager.Entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@NamedQuery(name = "getFineByMember",
            query = "SELECT f FROM Fine f" +
                    "WHERE f.member_id = :memberid")
class Fine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private double amount;

    private Date occurrence;

    private Date dueDate;

    private boolean status = true;

    @ManyToOne
    @Column(name = "member_id")
    private Member member;

    public Fine() {
    }

    public Fine(double amount, Date occurrence, Date dueDate, Member member) {
        this.amount = amount;
        this.occurrence = occurrence;
        this.dueDate = dueDate;
        this.member = member;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getOccurrence() {
        return occurrence;
    }

    public void setOccurrence(Date occurrence) {
        this.occurrence = occurrence;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
