package org.trade4life.stealer.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GameModel {
    private String id;
    private String title;
    private String imageUrl;
    private String psnURL;
    private String priceUsd;
    private String publisher;
}
