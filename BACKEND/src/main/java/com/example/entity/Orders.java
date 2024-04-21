package com.example.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Auditable;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "orders")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Orders implements Identifiable, Archivable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

    @OneToMany
    @JoinColumn(name = "id_order")
    private List<OrderItems> orderItems;

    @Column
    private Float total_amount;

    @Column
    private String status;

    @Column
    private LocalDateTime createdAt;

    @Column(nullable = false, columnDefinition = "TINYINT(1)")
    private boolean archived;
}