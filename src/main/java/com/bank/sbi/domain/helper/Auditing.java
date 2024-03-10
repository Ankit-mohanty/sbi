package com.bank.sbi.domain.helper;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
@Data
//@Embeddable
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class Auditing {
//    @CreationTimestamp
    @CreatedDate
    private LocalDateTime createdTime;
    @CreatedBy
    private String createdBy;
//    @UpdateTimestamp
    @LastModifiedDate
    private LocalDateTime updatedTime;
    @LastModifiedBy
    private String updatedBy;

}
