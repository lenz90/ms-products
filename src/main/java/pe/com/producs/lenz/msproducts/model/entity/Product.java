package pe.com.producs.lenz.msproducts.model.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "products")
@Setter
@Getter
@ToString
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

}
