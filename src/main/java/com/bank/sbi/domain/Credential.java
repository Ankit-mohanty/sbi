package com.bank.sbi.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class Credential {
    @Column(unique = true, length = 50, nullable = false)
    private String accountEmail;
    @Column(nullable = false)
    private String accountPassword;
}
