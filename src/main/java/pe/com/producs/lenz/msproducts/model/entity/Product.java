package pe.com.producs.lenz.msproducts.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "products")
public class Product implements Serializable {

    private static final long serialVersionUID = -4780055958011808990L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Double price;

    @Column(name = "create_at", columnDefinition = "DATE")
    private LocalDate createAt;

    public Long id() {
        return id;
    }

    public String name() {
        return name;
    }

    public Double price() {
        return price;
    }

    public LocalDate createAt() {
        return createAt;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setCreateAt(LocalDate createAt) {
        this.createAt = createAt;
    }
}
