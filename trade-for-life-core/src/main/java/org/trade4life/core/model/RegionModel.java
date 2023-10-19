package org.trade4life.core.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "regions")
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class RegionModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "currency")
    private String currency;
}
