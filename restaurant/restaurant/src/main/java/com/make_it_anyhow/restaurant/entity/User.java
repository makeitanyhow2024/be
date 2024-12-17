package com.make_it_anyhow.restaurant.entity;

import com.make_it_anyhow.common.configuation.Constant;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, unique = true)
  private String email; // 이메일 (고유)

  @Column(nullable = false)
  private String name; // 이름

  private String picture; // 프로필 사진 URL

  @Enumerated(EnumType.STRING)
  private Constant.AuthProvider provider; // 로그인 제공자 (Google 등)


}
