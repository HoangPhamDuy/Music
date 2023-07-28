package com.example.baitap_th01.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "baiviet")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_bviet")
    private Long postId;

    @Column(name = "tieude")
    private String title;

    @Column(name="ten_bhat")
    private String name;
    @ManyToOne
    @JoinColumn(name = "ma_tloai")
    private Category category;

    @Column(name = "tomtat")
    private String summary;

    @ManyToOne
    @JoinColumn(name = "ma_tgia")
    private Author author;

    @Column(name = "ngayviet")
    private Date postDate;
}
