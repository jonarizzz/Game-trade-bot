package org.trade4life.stealer.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "games")
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class GameModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "publisher")
    private String publisher;

    @Column(name = "store_game_id", unique = true)
    private String storeGameId;

    @Column(name = "store_price_usd")
    private Double storePriceUsd;

    @Column(name = "store_page_url")
    private String storePageUrl;

    @Column(name = "thumbnail_url")
    private String thumbnailUrl;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "platform_id", referencedColumnName = "id")
    private PlatformModel platform;
}
