package com.yurijivago.santanderdevweek2023.domain.model;

import jakarta.persistence.Entity;

@Entity(name = "tb_news")
public class News extends BaseItem{
    public News(Long id, String icon, String description) {
        super(id, icon, description);
    }
    public News() {
        super();
    }
}
