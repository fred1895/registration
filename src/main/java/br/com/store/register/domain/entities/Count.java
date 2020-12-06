package br.com.store.register.domain.entities;


import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "COUNT")
public class Count implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "ORIGINAL_VALUE")
    private BigDecimal originalValue;

    @Column(name = "FIXED_VALUE")
    private BigDecimal fixedValue;

    @Column(name = "DUE_DATE")
    private LocalDate dueDate;

    @Column(name = "PAYDAY")
    private LocalDate payday;

    @Column(name = "DAYS_LATE")
    private Integer daysLate;

    public Count() {

    }

    public Count(String name, BigDecimal originalValue, BigDecimal fixedValue, LocalDate dueDate, LocalDate payday, Integer daysLate) {
        this.name = name;
        this.originalValue = originalValue;
        this.fixedValue = fixedValue;
        this.dueDate = dueDate;
        this.payday = payday;
        this.daysLate = daysLate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getOriginalValue() {
        return originalValue;
    }

    public BigDecimal getFixedValue() {
        return fixedValue;
    }

    public void setFixedValue(BigDecimal fixedValue) {
        this.fixedValue = fixedValue;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public LocalDate getPayday() {
        return payday;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOriginalValue(BigDecimal originalValue) {
        this.originalValue = originalValue;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public void setPayday(LocalDate payday) {
        this.payday = payday;
    }

    public Integer getDaysLate() {
        return daysLate;
    }

    public void setDaysLate(Integer daysLate) {
        this.daysLate = daysLate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Count count = (Count) o;
        return id.equals(count.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Count{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", originalPrice=" + originalValue +
                ", dueDate=" + dueDate +
                ", payday=" + payday +
                ", daysLate=" + daysLate +
                '}';
    }
}
