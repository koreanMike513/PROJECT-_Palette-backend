package com.palette.back_end.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

@Entity
@Getter
@Builder
@DynamicInsert
@DynamicUpdate
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "post_pictures")
@SQLRestriction("is_deleted <> true")
@SQLDelete(sql = "UPDATE post_pictures SET is_deleted = true WHERE id = ?")
public class PostPicture extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(nullable = false, updatable = false)
  private Long postPictureId;

  @ManyToOne
  @JoinColumn(name = "portfolio_id")
  private Portfolio portfolio;

  @Setter
  @Column(columnDefinition = "VARCHAR(1000) NOT NULL COMMENT '주소'")
  private String url;
}
