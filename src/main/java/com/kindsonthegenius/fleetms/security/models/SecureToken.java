package com.kindsonthegenius.fleetms.security.models;

import javax.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SecureToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(unique = true)
    String token;

    @Column(updatable = false)
    @Basic(optional = false)
    LocalDateTime expiredAt;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    User user;

    public boolean isExpired() {
        return getExpiredAt().isBefore(LocalDateTime.now());
    }
}
